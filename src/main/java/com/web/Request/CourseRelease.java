package com.web.Request;

import com.web.core.Http;
import com.web.core.Request;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 17/7/2.
 */
public class CourseRelease {

    Map<Object,Object> params = new HashMap<Object, Object>();
    private String targetDomainCode ="";
    private String rankIds = "";
    private String userDomainCode = "";
    private String coueseId = "";

    public CourseRelease(String userDomainCode,String targetDomainCode,String rankIds,String coueseId){
        this.rankIds = rankIds;
        this.targetDomainCode = targetDomainCode;
        this.userDomainCode = userDomainCode;
        this.coueseId = coueseId;
    }



    private void addParam() {
        /*
        nowStatus
        0
        userDomainCode
        101002000000000
        vo.bean.id
        1013
        vo.bean.industryCodes
        00000000
        vo.bean.rankIds
        1621,1620,1619,1618,
        vo.bean.status
        1
        vo.bean.targetDomainCode
        101002001002002
		2002001001001000000
         */

        params.put("userDomainCode",userDomainCode);
        params.put("vo.bean.id",coueseId);
		if(userDomainCode.length() == 19) {
			params.put("vo.bean.industryCodes",getIndustryCodes());
            params.put("nowStatus",1);
		} else {
			params.put("vo.bean.industryCodes","00000000");
            params.put("nowStatus",0);
		}
        params.put("vo.bean.rankIds",rankIds);
        params.put("vo.bean.status",1);
        params.put("vo.bean.targetDomainCode",targetDomainCode);

    }

    public Request doRequest() {
        addParam();
        return new Http().setUrl("/sss/service/courseService!publishCourse.do").setParam(params).post();
    }
	
	public String getIndustryCodes() {
        String domainCode = "";
        if(targetDomainCode.length() == 19) {
            domainCode = targetDomainCode;
        } else {
            domainCode = userDomainCode;
        }
		Request request = new Http().setUrl("/bss/service/getIndustryCodes").setParam("domainCode",domainCode).get();
		String result = request.getResult();
		String[] industryCodes = result.split("\n")[1].split(";");
		String codes = "";
        for(String industryCode:industryCodes) {
            if(industryCode.length() == 9) {
                codes += industryCode.replaceAll("\r","");
            } else {
                codes += (industryCode + ";");
            }
        }
		return codes;
	}
}
