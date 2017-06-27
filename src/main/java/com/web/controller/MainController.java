package com.web.controller;

import com.web.Return.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

/**
 * Created by song on 17/4/25.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/settingEnvironmentPost",method = RequestMethod.POST)
    public String settingEnvironmentPost(@ModelAttribute("settingEnvironment") Environment environment) {
        File file = new File("./environment.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("文件创建失败");
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("文件创建失败");
                e.printStackTrace();
            }
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new FileWriter(file));
            writer.write(environment.getEnvironment());
            writer.write("\n");
            writer.write(environment.getUserAccount());
        } catch (FileNotFoundException e) {
            System.err.println("文件没有找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("文件写入失败");
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 重定向地址
        return "redirect:/";
    }

}
