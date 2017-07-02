package com.web.Return;

import com.web.controller.GetEnvironment;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.JsonHelper;
import com.web.util.UserInfo;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 2017/6/27.
 */
public class Environment {
    private String userAccount;
    private String environment;
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return this.environment;
    }


    @Test
    public void test() {
        Environment environment = new GetEnvironment().getInfo();
        String userAccount = environment.getUserAccount();
        Map<Object,Object> params = new HashMap<Object, Object>();
        params.put("dc",new Date().getTime());
        params.put("domainCode",new UserInfo(userAccount).getDomainCode());
        params.put("page",1);
        params.put("paperName","");
        params.put("paperType",0);
        params.put("rows",20);
        Request request1 = new Http().setUrl("/ess/service/paper/paperAo!doGetList.do").setParam(params).post();
        String result = request1.getResult();
        int count = Integer.valueOf(JsonHelper.getValue(result,"total").toString());
        String[] papers = JsonHelper.getValue(result,"rows").toString().split("},\\{");
        papers[0] += "}";
        papers[papers.length-1] = "{" + papers[papers.length-1];
        for(int i=1;i<papers.length-2;i++) {
            papers[i] = "{" + papers[i] + "}";
        }

        for (String s:papers) {
            System.err.println(s);
        }
    }

}
