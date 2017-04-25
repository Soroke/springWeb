package com.web.Return;

/**
 * Created by song on 17/4/25.
 * 课程返回
 */
public class Course {
    private String userAccount;
    private int courseType;
    private int courseCount;
    private int coursewareCount;

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getCourseCount() {
        return this.courseCount;
    }

    public void setCoursewareCount(int coursewareCount) {
        this.coursewareCount = coursewareCount;
    }

    public int getCoursewareCount() {
        return this.coursewareCount;
    }
}
