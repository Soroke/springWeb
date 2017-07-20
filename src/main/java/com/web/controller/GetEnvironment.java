package com.web.controller;

import com.web.Return.Environment;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by song on 2017/6/27.
 */
public class GetEnvironment {
    /**
     * log4j打log
     */
    private Logger log = Logger.getLogger(this.getClass());

    public Environment getInfo() {

        Environment environment = new Environment();

        File file = new File("./environment.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            if(!file.exists()) {
                try {
                    file.createNewFile();
                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
                    writer.write("测试环境");
                    writer.write("\n");
                    writer.write("songrenkun");
                } catch (IOException e) {
                    System.err.println("创建文件失败");
                    e.printStackTrace();
                }
            }
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String lineTxt;
            while((lineTxt = reader.readLine()) != null) {
                if(lineTxt.equals("测试环境") || lineTxt.equals("预上线环境") || lineTxt.equals("线上环境")) {
                    environment.setEnvironment(lineTxt);
                } else {
                    environment.setUserAccount(lineTxt);
                }
            }

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
