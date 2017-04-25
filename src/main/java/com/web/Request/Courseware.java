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
 * 课件请求
 */
public class Courseware {
    Map<Object,Object> param = new HashMap<Object, Object>();

    public void addParamForCourseId(String courseId) {
        param.put("vo.bean.courseId",courseId);
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
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "批量添加课件" + new Date().getTime());

        //课件类型
        param.put("vo.bean.courseWareType",1);

        //课件模板
        param.put("vo.bean.courseWareTemplate",1);

        //排序号
        param.put("vo.bean.sort",1);

        //课件图片
        param.put("vo.bean.resourseUrl","http://qdtestfile.faxuan.net/study/55f98538d3234d239b2e5e3fc91c493a.JPG");

        //课件描述
        param.put("vo.bean.courseWareDiscription","我是课件描述！！");
    }

    /**
     * 请求添加课程接口
     * @return 请求返回状态
     */
    public Request doRequest() {
        addParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
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
