package com.web.Request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.web.Return.Environment;
import com.web.controller.GetEnvironment;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.GetDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by song on 17/4/25.
 * 课程请求
 */
public class Course {

    /**
     * 图片
     */
    List<String> images = new ArrayList<>();
    //iamge count
    int imageCount =0;

    /**
     * 环境信息
     */
    Environment en = new GetEnvironment().getInfo();

    public Course() {
        switch (en.getEnvironment()) {
            case "测试环境":
                images.add("http://qdtestfile.faxuan.net/study/4ddb21aa6e2a47f9917d20fc78402abc.jpg");
                images.add("http://qdtestfile.faxuan.net/study/f26cdaa469c74c86bd70320daac290e3.jpg");
                images.add("http://qdtestfile.faxuan.net/study/a4c68b364aca4793ada25827360d1a39.jpg");
                images.add("http://qdtestfile.faxuan.net/study/50cc77f7a3914e53bc2c000a7035244d.jpg");
                images.add("http://qdtestfile.faxuan.net/study/95a04573cf424ce9a4ca37800d561052.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7ec0a7b8209544928981bb0c62214264.jpg");
                images.add("http://qdtestfile.faxuan.net/study/06087444e2194a628834db10ea78ec1e.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7512e243457648e09900137279cea837.jpg");
                images.add("http://qdtestfile.faxuan.net/study/d26fb058ffe145f585034fa20e0043b1.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7c33aaafd94e42f8a854234ccc676a34.jpg");
                images.add("http://qdtestfile.faxuan.net/study/4159f04ca13942cab69aa4c2ee3ea035.jpg");
                images.add("http://qdtestfile.faxuan.net/study/3e7d229cd86948308e03afdcc1915c3c.jpg");
                images.add("http://qdtestfile.faxuan.net/study/65129e9dec4a426287598329873c42ec.jpg");
                images.add("http://qdtestfile.faxuan.net/study/e1b3e063098149fa9513f54ce67c931a.jpg");
                images.add("http://qdtestfile.faxuan.net/study/2ceabbcd50e5437ca2e7bffb1848d8f4.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7e5dbb08341f4ea68ad71655edb0d34c.jpg");
                images.add("http://qdtestfile.faxuan.net/study/96629eb76a1a4c78bd66abff2efeca28.jpg");
                images.add("http://qdtestfile.faxuan.net/study/9c530f8c672e479ab07c66cbc9ad56ef.jpg");
                images.add("http://qdtestfile.faxuan.net/study/57cb0e760bda4d54a2c7ec7caa27c5b8.jpg");
                images.add("http://qdtestfile.faxuan.net/study/93d8207dd2394b1d9d60514c7029f131.jpg");
                images.add("http://qdtestfile.faxuan.net/study/514e6c26b6114580884445db4a6537a5.jpg");
                images.add("http://qdtestfile.faxuan.net/study/aaa578351b804a3bb6aa3865c9cc8062.jpg");
                images.add("http://qdtestfile.faxuan.net/study/3138f815956442f68a7ca6d495de92d6.jpg");
                images.add("http://qdtestfile.faxuan.net/study/22f74b6171ff4adf9df2b751f92c059b.jpg");
                images.add("http://qdtestfile.faxuan.net/study/f926245a03d04af6838a464916e546dd.jpg");
                images.add("http://qdtestfile.faxuan.net/study/31d9d01af5844f3aa3dfbc93c57fb831.jpg");
                images.add("http://qdtestfile.faxuan.net/study/49af84d2256549d7b65f80335b6a2e3b.jpg");
                images.add("http://qdtestfile.faxuan.net/study/d424f1438d784976b2cb3d8b55d7921c.JPG");
                images.add("http://qdtestfile.faxuan.net/study/828cfbe5dc974e8394dd30b204516801.JPG");
                imageCount = 29;
                break;
            case "预上线环境":
                images.add("http://stagfile.faxuan.net/study/0284efea8eaa4c53849892f1bd09473d.jpg");
                images.add("http://stagfile.faxuan.net/study/9b625388bf454efa9ad0f24848c598fb.JPG");
                images.add("http://stagfile.faxuan.net/study/9647f879e9a147c68f118f59a0b42423.JPG");
                images.add("http://stagfile.faxuan.net/study/5cfdd3af7aa9457995bceafe855936b3.jpg");
                images.add("http://stagfile.faxuan.net/study/7219a35ce7ab41e8ac13aea52e5d55f2.JPG");
                images.add("http://stagfile.faxuan.net/study/af068e7ccff94918a1badd73e8ebb176.jpg");
                images.add("http://stagfile.faxuan.net/study/04d3b994f46748ab94f12a9d6a714a08.jpg");
                images.add("http://stagfile.faxuan.net/study/25a55975c91c4e298e45e4c4d0defb1e.jpg");
                images.add("http://stagfile.faxuan.net/study/06dfd185d5bb4f8b93972f167721f4f6.jpg");
                images.add("http://stagfile.faxuan.net/study/9b063dbaf25d4436be8c5d8fb0f64bf2.jpg");
                images.add("http://stagfile.faxuan.net/study/39dfdf4006ed408084067d05e91fadc0.jpg");
                images.add("http://stagfile.faxuan.net/study/92960f4ada6845ec975d60cfb272adae.jpg");
                images.add("http://stagfile.faxuan.net/study/d069568bece34492806bdf39b7bc8910.jpg");
                images.add("http://stagfile.faxuan.net/study/5e4d0877ad4b48cab6f8943c0b896347.JPG");
                images.add("http://stagfile.faxuan.net/study/87f757f45c6f47cab6c16f63b655030d.jpg");
                images.add("http://stagfile.faxuan.net/study/b2de5d8727d849b288f088ff0502c2a7.jpg");
                images.add("http://stagfile.faxuan.net/study/3751799d39a64311974e3307dd98b60d.jpg");
                images.add("http://stagfile.faxuan.net/study/cdbc8864883b4051b39e4f5de08b7c51.jpg");
                images.add("http://stagfile.faxuan.net/study/395536c74fe043af961c80b6eb958f61.jpg");
                images.add("http://stagfile.faxuan.net/study/c1ead997a1a243679e3996088a46220d.jpg");
                images.add("http://stagfile.faxuan.net/study/0035f4468ec74247b58295a54f1b897a.jpg");
                images.add("http://stagfile.faxuan.net/study/66b7213d5f8e41dd9bb8242e98757020.jpg");
                images.add("http://stagfile.faxuan.net/study/36afdeb50be942de833c3e9a5a39bfc0.jpg");
                images.add("http://stagfile.faxuan.net/study/38916a339d8b45f2afa7ff89ba4c14c8.jpg");
                images.add("http://stagfile.faxuan.net/study/54e3437b4ad84165b3bb6089391e3291.jpg");
                images.add("http://stagfile.faxuan.net/study/63beb870fd9449b98a65135a878cd3fb.jpg");
                images.add("http://stagfile.faxuan.net/study/7339a8f6167f4d368b32135dfefabae1.jpg");
                images.add("http://stagfile.faxuan.net/study/267fd310be344630aab353a7b6a968f8.jpg");
                imageCount = 28;
                break;
            case "线上环境":
                images.add("http://file.faxuan.net/study/60462bef04de4551871a1497788e0c48.jpg");
                images.add("http://file.faxuan.net/study/86982bf0b9e942d5b09296576bc370e3.jpg");
                images.add("http://file.faxuan.net/study/f2ded9ee875c4fc69c0c3cc2cf8ea08d.jpg");
                images.add("http://file.faxuan.net/study/a3efedb2ddc2401ab4d6a0dc6c3b920f.JPG");
                images.add("http://file.faxuan.net/study/3e47c309eb6344e19ba35434416f912b.JPG");
                images.add("http://file.faxuan.net/study/0797f43716c344f4916a537d4ad48fdb.JPG");
                images.add("http://file.faxuan.net/study/b4dab26fdc4a48658c262349f502d891.jpg");
                images.add("http://file.faxuan.net/study/a4e17c5c0d734246b9d93fc60913f2f9.JPG");
                images.add("http://file.faxuan.net/study/9b8a063c95364df7b56f6fc63870854d.jpg");
                images.add("http://file.faxuan.net/study/204852f573ba4c079846f391ac366502.jpg");
                images.add("http://file.faxuan.net/study/053617ca8f4f45568475a75b08599350.jpg");
                images.add("http://file.faxuan.net/study/60e11a78adc842bbb478a342c0c52f4f.jpg");
                images.add("http://file.faxuan.net/study/a15b9dfc0e8a4a3fae883d0a328b28d7.jpg");
                images.add("http://file.faxuan.net/study/c40462c5e570493cb79a9c5300a1ba66.jpg");
                images.add("http://file.faxuan.net/study/5a1642686f08424c9fc769447a154358.jpg");
                images.add("http://file.faxuan.net/study/509e32fca1e844c2aca58fd852ddbebf.jpg");
                images.add("http://file.faxuan.net/study/73d30bb004d14de58636d0524844dabe.jpg");
                images.add("http://file.faxuan.net/study/38d47a4fe67b47b9a2f1ceae193ca6c1.jpg");
                images.add("http://file.faxuan.net/study/d0694628bb844aecb9d5a6629022f134.jpg");
                images.add("http://file.faxuan.net/study/ab3a096e2f2c417abf72893bdff3633e.jpg");
                images.add("http://file.faxuan.net/study/500921fca63f41d69dc75419605d554a.jpg");
                images.add("http://file.faxuan.net/study/05318687119d4536a8f95ddb8ee87328.jpg");
                images.add("http://file.faxuan.net/study/ff1a49e098fe43b096f652d3a1a69a7a.jpg");
                images.add("http://file.faxuan.net/study/c296362fb56347438c0bbb376b3e7922.jpg");
                images.add("http://file.faxuan.net/study/867dcd97c99641738cf9f374c755461f.jpg");
                images.add("http://file.faxuan.net/study/73e91c6eb7e146529fb72a95aab70597.jpg");
                images.add("http://file.faxuan.net/study/003c8e5452cc4dc79082fba910cc88b2.jpg");
                images.add("http://file.faxuan.net/study/730506b7b9154ea7bde59847d8184c91.jpg");
                imageCount=28;
        }
    }

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
        param.put("vo.bean.jpgPath",images.get((int)(Math.random()*imageCount)));

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
