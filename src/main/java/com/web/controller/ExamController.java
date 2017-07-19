package com.web.controller;

import com.web.Return.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

/**
 * Created by song on 2017/7/19.
 */
@Controller
public class ExamController {


    /**
     * 添加考试页面
     */
    @RequestMapping(value = "/exam/addExam",method = RequestMethod.GET)
    public String addCourse(Model model){
        Environment environment = new GetEnvironment().getInfo();
        model.addAttribute(environment);
        return "/exam/addExam";
    }


    /**
     * 处理修改环境和管理员请求
     * @param environment
     * @return
     */
    @RequestMapping(value = "/exam/settingEnvironmentPost",method = RequestMethod.POST)
    public String settingEnvironmentPost(@ModelAttribute("settingEnvironment") Environment environment) {
        File file = new File("./environment.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("创建文件失败");
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("创建文件失败");
            }
        }

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            writer.write(environment.getEnvironment());
            writer.write("\n");
            writer.write(environment.getUserAccount());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("没有找到文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("写入文件失败");

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
        return "redirect:/exam/addExam";
    }
}
