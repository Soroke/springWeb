package com.web.util;

import java.util.Calendar;

/**
 * Created by song on 2017/7/4.
 */
public class GetDate {

    /**
     * 获取电脑时间
     * @return 返回日期格式例如：String 数组
     */
    public static String[] getStringArrayDate() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int monthR = month+1;
        int date = c.get(Calendar.DATE);
        int dateR = date;
        String datea = "";
        if(dateR < 10) {
            datea = "0" + String.valueOf(dateR);
        } else {
            datea = String.valueOf(dateR);
        }
        String montha = "";
        if(monthR < 10) {
            montha = "0" + String.valueOf(monthR);
        } else {
            montha = String.valueOf(monthR);
        }
        String date1[] = {String.valueOf(year),montha,datea};
        return date1;
    }

    /**
     * 获取电脑时间
     * @return 返回具体时分秒格式例如：17:36:52
     */
    public static String getDateSceond() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String date2 = hour + ":" + minute + ":" + second;
        return date2;
    }
}
