package com.web.controller;

import com.web.Return.Environment;

import java.io.*;

/**
 * Created by song on 2017/6/27.
 */
public class GetEnvironment {
    public static Environment getInfo() {

        Environment environment = new Environment();

        File file = new File("./environment.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader( new FileReader(file));
            String lineTxt;
            while((lineTxt = reader.readLine()) != null) {
//System.out.println(lineTxt);
                if(lineTxt.equals("0") || lineTxt.equals("1") || lineTxt.equals("2")) {
                    environment.setEnvironment(lineTxt);
                } else {
                    environment.setUserAccount(lineTxt);
                }
            }
//System.out.println("环境：" + environment.getEnvironment() + "\t用户：" + environment.getUserAccount());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return environment;
    }
}
