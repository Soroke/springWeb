package com.web.controller;

import com.web.Return.Environment;
import com.web.core.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

/**
 * Created by song on 17/4/25.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        Environment environment = new GetEnvironment().getInfo();
        model.addAttribute(environment);
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
            writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
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
//System.out.println("Environment:"+environment.getEnvironment() + "\tUserAccount:" + environment.getUserAccount());
//System.out.println("Environment:"+ new GetEnvironment().getInfo().getEnvironment() + "\tUserAccount:" + new GetEnvironment().getInfo().getUserAccount());
        // 重定向地址
        return "redirect:/";
    }

    @RequestMapping(value = "/test/test",method = RequestMethod.GET)
    public String gettext(Model model) {
        Environment environment = new GetEnvironment().getInfo();
        model.addAttribute(environment);
        return "/test/test";
    }

}
