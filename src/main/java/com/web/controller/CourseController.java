package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.Request.Courseware;
import com.web.Return.Course;
import com.web.core.Http;
import com.web.core.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        for(int i=0;i<course.getCourseCount();i++) {
            com.web.Request.Course course1 = new com.web.Request.Course();
            course1.addParamForCourseType(course.getCourseType());
            course1.addParamForUserInfo(course.getUserAccount());
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
        //获取用户的doaminCode和usernaem
        Map<Object,Object> param1 = new HashMap<Object, Object>();
        param1.put("userAccount",course.getUserAccount());
        Request request1 = new Http().setUrl("/useris/service/getdetail").setParam(param1).get();
        Assert.assertEquals(request1.getStatusCode(),200);
        String domainCode = getRequestValue(request1.getResult(),"domainCode");
        String userName = getRequestValue(request1.getResult(),"userName");

        //添加课程
        com.web.Request.Course course1 = new com.web.Request.Course();
        course1.addParamForCourseType(course.getCourseType());
        course1.addParamForUserInfo(course.getUserAccount());
        Request request = course1.doRequest();


        String courseId = getCourseIdByCourseName(domainCode,request.getParams().get("vo.bean.courseName").toString());
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



    public String getRequestValue(String json, String key){
        JSONArray ja = JSON.parseArray(json);
        for(int i=0; i<ja.size()-1; i+=2){
            if(ja.get(i).toString().equals(key)){
                return ja.get(i+1).toString();
            }

        }
        return null;
    }
}
