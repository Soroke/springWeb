package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.Request.Courseware;
import com.web.Return.Course;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 17/4/25.
 */
@Controller
public class CourseController {

    /**
     * 添加课程页面
     */
    @RequestMapping(value = "/course/addCourse",method = RequestMethod.GET)
    public String addCourse(){
        return "/course/addCourse";
    }

    /**
     * 处理课程添加请求
     */
    @RequestMapping(value = "/course/addCoursePost",method = RequestMethod.POST)
    public String addCoursePost(@ModelAttribute("addCourse") Course course) {

        //获取管理员domainCode和userName
        UserInfo userInfo = new UserInfo(course.getUserAccount());
        String domainCode = userInfo.getDomainCode();
        String userName = userInfo.getUserName();

        //循环请求添加课程接口
        for(int i=0;i<course.getCourseCount();i++) {
            com.web.Request.Course course1 = new com.web.Request.Course();
            course1.addParamForCourseType(course.getCourseType());
            course1.addParamForUserInfo(domainCode,userName);
            course1.doRequest();
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
        UserInfo userInfo = new UserInfo(course.getUserAccount());
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
        param.put("rows",20);
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
}
