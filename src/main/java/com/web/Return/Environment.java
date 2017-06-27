package com.web.Return;

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
