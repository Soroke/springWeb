package com.web.Request;

import com.web.core.Http;
import com.web.core.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 17/7/2.
 */
public class CoursePaper {
    Map<Object,Object> params = new HashMap<Object, Object>();

    private String coueseId;
    private String paperIds;

    public CoursePaper(String coueseId,String paperIds){
        this.coueseId = coueseId;
        this.paperIds = paperIds;
    }

    public Request doRequest() {
        params.put("vo.bean.id",coueseId);
        params.put("vo.testPaperIds",paperIds);

        return new Http().setUrl("/sss/service/courseService!matchCoursePaper.do").setParam(params).post();
    }
}
