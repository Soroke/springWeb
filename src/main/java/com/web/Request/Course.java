package com.web.Request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.web.core.Http;
import com.web.core.Request;
import org.testng.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 17/4/25.
 * 课程请求
 */
public class Course {
    Map<Object,Object> param = new HashMap<Object, Object>();

    public void addParamForCourseType(int type) {
        if(type  == 0) {
            param.put("vo.bean.courseClassify","12");
        } else {
            param.put("vo.bean.courseClassify","11");
        }
    }


    public String  addParamForUserInfo(String userAccount) {
        Map<Object,Object> param1 = new HashMap<Object, Object>();
        param1.put("userAccount",userAccount);
        Request request = new Http().setUrl("/useris/service/getdetail").setParam(param1).get();
        Assert.assertEquals(request.getStatusCode(),200);
        param.put("vo.organNo",this.getRequestValue(request.getResult(),"domainCode"));
        param.put("vo.userId",this.getRequestValue(request.getResult(),"userName"));
        return getRequestValue(request.getResult(),"domainCode");
    }

    private void addParam() {
        //课程名称时间戳
        param.put("vo.bean.courseName", "批量添加课程" + new Date().getTime());

        //语言标签
        param.put("vo.bean.languageType",0);

        //排序号
        param.put("vo.bean.courseSort",1);

        //已学人数
        param.put("vo.bean.courseCount",10);

        //课程图片
        param.put("vo.bean.jpgPath","http://qdtestfile.faxuan.net/study/55f98538d3234d239b2e5e3fc91c493a.JPG");

        //课程描述
        param.put("vo.bean.courseDiscription","我是课程描述！！");
    }

    /**
     * 请求添加课程接口
     * @return 请求返回状态
     */
    public Request doRequest() {
        addParam();
        return new Http()
                .setUrl("/sss/service/courseService!addCourse.do")
                .setParam(param)
                .post();
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
