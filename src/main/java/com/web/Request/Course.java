package com.web.Request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.GetDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by song on 17/4/25.
 * 课程请求
 */
public class Course {

    String [] images = {"http://qdtestfile.faxuan.net/study/4ddb21aa6e2a47f9917d20fc78402abc.jpg","http://qdtestfile.faxuan.net/study/fd7cdb38e3b94ea68d11e63fa312540f.jpg"
            ,"http://qdtestfile.faxuan.net/study/b49a9c28a14d407683f8b2adbd307b9a.jpg","http://qdtestfile.faxuan.net/study/176ad4593d4f4b55a05e41f3bcb249cb.jpg"
            ,"http://qdtestfile.faxuan.net/study/f26cdaa469c74c86bd70320daac290e3.jpg","http://qdtestfile.faxuan.net/study/a66719db3a234f0a9874e932b146b839.jpg"
            ,"http://qdtestfile.faxuan.net/study/72b5d2d6c453479cafd2cb47093dedbc.jpg","http://qdtestfile.faxuan.net/study/a4c68b364aca4793ada25827360d1a39.jpg"
            ,"http://qdtestfile.faxuan.net/study/50cc77f7a3914e53bc2c000a7035244d.jpg","http://qdtestfile.faxuan.net/study/0f65dcd498d34953928fae93f6049766.jpg"
            ,"http://qdtestfile.faxuan.net/study/a795537e32964473b57c35f81bad6b70.jpg","http://qdtestfile.faxuan.net/study/6ddd3de3f8c14884aedc20ee0459bfe7.jpg"
            ,"http://qdtestfile.faxuan.net/study/02bf421cbd3f4d66acba3a846f20412a.jpg","http://qdtestfile.faxuan.net/study/05b6f2f9ac544b838cf6e35eb8431de3.jpg"};


    Map<Object,Object> param = new HashMap<Object, Object>();

    public void addParamForCourseType(int type) {
        String[] dates = GetDate.getStringArrayDate();
        String date = dates[0] + "-" + dates[1] + "-" + dates[2] + " " + GetDate.getDateSceond();

        if(type  == 0) {
            param.put("vo.bean.courseClassify","12");
            param.put("vo.bean.courseName", "必修课程" +date);
        } else {
            param.put("vo.bean.courseClassify","11");
            param.put("vo.bean.courseName", "选修课程" +date);
        }
    }

    /**
     * 设置请求参数的domainCode和userName
     * @param userName
     * @param domainCode
     */
    public void addParamForUserInfo(String domainCode,String userName) {
        param.put("vo.organNo",domainCode);
        param.put("vo.userId",userName);
    }

    private void addParam() {

        //语言标签
        param.put("vo.bean.languageType",0);

        //排序号
        param.put("vo.bean.courseSort",1);

        //已学人数
        param.put("vo.bean.courseCount",100);

        //课程图片
        param.put("vo.bean.jpgPath",images[(int)(Math.random()*14)]);

        //课程描述
        param.put("vo.bean.courseDiscription","我是课程描述，我有1000个字；美国法官宣布绑架中国访问学者的嫌疑人不得保释新华社芝加哥7月3日电，美国伊利诺伊州中部地区联邦法院３日宣布，绑架中国访问学者章莹颖的嫌疑人布伦特·A·克里斯滕森不得保释在下次庭审前继续收押。这一决定是由联邦法官埃里克·朗在当地时间当天上午10时左右举行的针对克里斯滕森的法庭聆讯上作出的。当天的聆讯仅持续9分钟，克里斯滕森始终保持沉默。根据法官作出的决定，针对克里斯滕森的下次聆讯将在当地时间5日下午3时举行。美国地区检察官办公室发言人莎伦·保罗在聆讯结束后对媒体表示，如果克里斯滕森最终被判绑架罪名成立，他将面临终身监禁。美国联邦调查局6月30日宣布，当晚逮捕白人男子布伦特·A·克里斯滕森，指控他涉嫌绑架中国访问学者章莹颖。");
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
}
