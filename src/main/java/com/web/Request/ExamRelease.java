package com.web.Request;

import com.web.core.Http;
import com.web.core.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 2017/7/20.
 */
public class ExamRelease {

    Map<Object,Object> params = new HashMap<Object, Object>();
    private String targetDomainCode ="";
    private String rankIds = "";
    private String userDomainCode = "";
    private String examId = "";
    private String userAccount = "";
    private String sid = "";

    public ExamRelease(String userDomainCode,String targetDomainCode,String rankIds,String examId,String userAccount,String sid){
        this.rankIds = rankIds;
        this.targetDomainCode = targetDomainCode;
        this.userDomainCode = userDomainCode;
        this.examId = examId;
        this.userAccount = userAccount;
        this.sid = sid;
    }

    private void addParam() {
        /*
        examId
        819
        targetDomainCode
        101021001003000
        rank
        159;160;161;162;163
        industryCodes
        10600000;10700000;10800000
        operator
        songrenkun
        sid
        6d61df586140429085b5739b958e3312
        industryDomainFlag
        1
        targetParentCode
        2021001001001000000
         */
        params.put("examId",examId);
        params.put("targetDomainCode",targetDomainCode);
        params.put("rank",rankIds);
        if(userDomainCode.length() == 19) {
            params.put("industryCodes",getIndustryCodes());
            params.put("industryDomainFlag",1);
            params.put("targetParentCode","");
        } else {
            params.put("industryCodes","00000000");
            params.put("industryDomainFlag",0);
            params.put("targetParentCode","");
        }
        params.put("sid",sid);
        params.put("operator",userAccount);

    }

    /**
     * 请求添加考试接口
     * @return
     */
    public Request doRequest() {
        addParam();
        return new Http().setUrl("/ess/service/exam/examAo!doPublish.do").setParam(params).post();
    }

    private String getIndustryCodes() {
        String domainCode = "";
        String codes = "";
        if(targetDomainCode.length() == 19) {
            domainCode = targetDomainCode;
        } else {
            domainCode = userDomainCode;
        }
        Request request = new Http().setUrl("/bss/service/getIndustryCodes").setParam("domainCode",domainCode).get();
        String result = request.getResult();
        String[] industryCodes = result.split("\n")[1].split(";");
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
