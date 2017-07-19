package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.Request.CoursePaper;
import com.web.Request.CourseRelease;
import com.web.Request.Courseware;
import com.web.Return.Course;
import com.web.Return.Environment;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.JsonHelper;
import com.web.util.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by song on 17/4/25.
 */
@Controller
public class CourseController {

   // Environment environment = new GetEnvironment().getInfo().getUserAccount();
   // String userAccount = environment.getUserAccount();

    /**
     * 添加课程页面
     */
    @RequestMapping(value = "/course/addCourse",method = RequestMethod.GET)
    public String addCourse(Model model){
        Environment environment = new GetEnvironment().getInfo();
        model.addAttribute(environment);
        return "/course/addCourse";
    }



    /**
     * 处理课程添加请求
     */
    @RequestMapping(value = "/course/addCoursePost",method = RequestMethod.POST)
    public String addCoursePost(@ModelAttribute("addCourse") Course course) {

        //记录添加课程的ID
        List<String> courseIds = new ArrayList<String>();

        //获取管理员domainCode和userName
        UserInfo userInfo = new UserInfo(new GetEnvironment().getInfo().getUserAccount());
        String domainCode = userInfo.getDomainCode();
        String userName = userInfo.getUserName();

        //循环请求添加课程接口
        for(int i=0;i<course.getCourseCount();i++) {
            com.web.Request.Course course1 = new com.web.Request.Course();
            course1.addParamForCourseType(course.getCourseType());
            course1.addParamForUserInfo(domainCode,userName);
            Request request = course1.doRequest();
            //获取课程Id
            String courseId = getCourseIdByCourseName(domainCode,request.getParams().get("vo.bean.courseName").toString());
            courseIds.add(courseId);
        }

        //如果用户选择了纯文字课件循环提添加
        if(course.getPlaintext() == 1) {
            for(int i=0;i<courseIds.size();i++) {
                Courseware courseware = new Courseware();
                courseware.addParamForCourseId(courseIds.get(i));
                courseware.addParamForUserInfo(domainCode, userName);
                courseware.doPaintextRequest();
            }
        }
        //如果用户选择了图文课件循环提添加
        if(course.getImagetext() == 1) {
            for(int i=0;i<courseIds.size();i++) {
                Courseware courseware = new Courseware();
                courseware.addParamForCourseId(courseIds.get(i));
                courseware.addParamForUserInfo(domainCode, userName);
                courseware.doImagetextRequest();
            }
        }
        //如果用户选择了图片课件循环提添加
        if(course.getImage() == 1) {
            for(int i=0;i<courseIds.size();i++) {
                Courseware courseware = new Courseware();
                courseware.addParamForCourseId(courseIds.get(i));
                courseware.addParamForUserInfo(domainCode, userName);
                courseware.doImageRequest();
            }
        }
        //如果用户选择了视频课件循环提添加
        if(course.getVideo() == 1) {
            for(int i=0;i<courseIds.size();i++) {
                Courseware courseware = new Courseware();
                courseware.addParamForCourseId(courseIds.get(i));
                courseware.addParamForUserInfo(domainCode, userName);
                courseware.doVideoRequest();
            }
        }

        //获取用户选择的练习题ID
        String[] papers = {course.getPaper1(),course.getPaper2(),course.getPaper3(),course.getPaper4()
                ,course.getPaper5(),course.getPaper6(),course.getPaper7(),course.getPaper8(),course.getPaper9(),course.getPaper10()};
        String paper="";
        for(String pap:papers) {
            if(!pap.equals("") || !(pap =="")) {
                paper = paper + pap + ",";
            }
        }
        //关联练习题
        if(!paper.equals("") || !(paper == "")) {
            for(int i =0;i<courseIds.size();i++) {
                CoursePaper coursePaper = new CoursePaper(courseIds.get(i),paper);
                coursePaper.doRequest();
            }
        }

        //发布课程
        if(!course.getDomainCode().equals("") || !(course.getDomainCode() == "")) {
            for(int i =0;i<courseIds.size();i++) {
                CourseRelease courseRelease = new CourseRelease(domainCode, course.getDomainCode(), getRankIds(getAreaCodeByDomainCode(course.getDomainCode())), courseIds.get(i));
                courseRelease.doRequest();
            }
        }



        // 重定向地址
        return "redirect:/course/addCourse";

    }

    /**
     * 处理课程添加请求1
     */
    @RequestMapping(value = "/course/addCoursePost1",method = RequestMethod.POST)
    public String addCoursePost1(@ModelAttribute("addCourse1") Course course,Model model) {
        //获取管理员domainCode和userName
        UserInfo userInfo = new UserInfo(new GetEnvironment().getInfo().getUserAccount());
        String domainCode = userInfo.getDomainCode();
        String userName = userInfo.getUserName();

        //添加课程
        com.web.Request.Course course1 = new com.web.Request.Course();
        course1.addParamForCourseType(course.getCourseType());
        course1.addParamForUserInfo(domainCode,userName);
        Request request = course1.doRequest();

        //获取课程Id
        String courseId = getCourseIdByCourseName(domainCode,request.getParams().get("vo.bean.courseName").toString());

        //为该课程循环添加课件
        for(int i=0;i<course.getCoursewareCount();i++) {
            Courseware courseware = new Courseware();
            courseware.addParamForCourseId(courseId);
            courseware.addParamForUserInfo(domainCode,userName);
            courseware.doRequest();
        }

        model.addAttribute("msg","添加成功");
        // 重定向地址
        return "redirect:/course/addCourse";

    }




    /**
     * 根据课程名称获取课程ID
     * @param domainCode
     * @param CourseName
     * @return
     */
    public String getCourseIdByCourseName(String domainCode,String CourseName) {
        Map<Object,Object> param = new HashMap<Object, Object>();
        param.put("page",1);
        param.put("rows",50);
        param.put("vo.organNo",domainCode);
        param.put("vo.bean.status","");
        param.put("vo.bean.courseName","");
        param.put("vo.bean.courseClassify","");

        Request request = new Http().setUrl("/sss/service/courseService!manageCourse.do")
                .setParam(param).post();

        for(int i=0; i< JSON.parseObject(request.getResult()).getJSONArray("rows").size(); i++){
            if(getValue(request.getResult(), "rows["+i+"].courseName").equals(CourseName)){
                String id = getValue(request.getResult(), "rows["+i+"].id").toString();
                return id;
            }
        }
        return null;
    }

    /**
     * 取json中的值
     * @param json
     * @param key
     * @return
     */
    public Object getValue(Object json, String key) {
        key = key.replace("]", "");
        key = key.replace("[", ".");
        String keys[] = key.split("\\.");

        if(json instanceof JSONArray){
            if(keys.length==1){
                return ((JSONArray) json).get(Integer.parseInt(keys[0]));
            }else {
                return getValue(((JSONArray) json).get(Integer.parseInt(keys[0])), key.substring(key.indexOf(".")+1));
            }
        }
        if(json instanceof JSONObject){
            if(keys.length==1){
                return ((JSONObject) json).get(keys[0]);
            }else {
                return getValue(((JSONObject) json).get(keys[0]), key.substring(key.indexOf(".")+1));
            }
        }
        if(json instanceof String){
            return getValue(JSON.parse((String) json), key);
        }
        return null;
    }


    /**
     *
     * 处理修改环境和管理员请求
     * @param environment
     * @return
     */
    @RequestMapping(value = "/course/settingEnvironmentPost",method = RequestMethod.POST)
    public String settingEnvironmentPost(@ModelAttribute("settingEnvironment") Environment environment) {
        File file = new File("./environment.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("创建文件失败");
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("创建文件失败");
                e.printStackTrace();
            }
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            writer.write(environment.getEnvironment());
            writer.write("\n");
            writer.write(environment.getUserAccount());
        } catch (FileNotFoundException e) {
            System.err.println("没有找到文件");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("写入文件失败");
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//System.out.println("Environment:"+environment.getEnvironment() + "\tUserAccount:" + environment.getUserAccount());
//System.out.println("Environment:"+ new GetEnvironment().getInfo().getEnvironment() + "\tUserAccount:" + new GetEnvironment().getInfo().getUserAccount());
        // 重定向地址
        return "redirect:/course/addCourse";
    }

    /**
     * 根据单位Code获取单位的区域Code
     * @param domainCode
     * @return
     */
    public String getAreaCodeByDomainCode(String domainCode) {
        Request request = new Http().setUrl("/sss/service/courseService!doGetAreaCodeByDomainCode.do").setParam("domainCode",domainCode).get();
        String areaCode = JsonHelper.getValue(request.getResult(),"areaCode").toString().substring(0,2);
        return areaCode + "0000";
    }

    /**
     * 根据区域code获取rankId
     * @param areaCode
     * @return
     */
    public String getRankIds(String areaCode) {

        String rankIds = "";

        Request request = new Http().setUrl("/bss/service/rankService!doGetRankForPulish.do").setParam("areaCode",areaCode).get();
        String result = request.getResult();
        String[] ranks = result.split("},\\{");
        if(ranks.length == 1) {
            ranks[0] = ranks[0].substring(1);
            ranks[0] = ranks[0].substring(0,ranks[0].length()-1);
        }
        ranks[0] += "}";
        ranks[0] = ranks[0].substring(1);
        ranks[ranks.length-1] = "{" + ranks[ranks.length-1];
        ranks[ranks.length-1] = ranks[ranks.length-1].substring(0,ranks[ranks.length-1].length()-1);

        for(int i=1;i<ranks.length-1;i++) {
            ranks[i] = "{" + ranks[i] + "}";
        }

        for (int i=0;i<ranks.length;i++) {
            rankIds += JsonHelper.getValue(ranks[i],"id").toString() + ",";
        }

        return rankIds;

    }


}
