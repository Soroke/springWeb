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

}
