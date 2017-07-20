package com.web.controller;

import com.web.Request.CoursePaper;
import com.web.Request.CourseRelease;
import com.web.Request.Courseware;
import com.web.Request.ExamRelease;
import com.web.Return.Exam;
import com.web.Return.Environment;
import com.web.core.Http;
import com.web.core.Request;
import com.web.util.JsonHelper;
import com.web.util.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 处理考试添加请求
     */
    @RequestMapping(value = "/exam/addExamPost",method = RequestMethod.POST)
    public String addCoursePost(@ModelAttribute("addExam") Exam exam) {

        //记录添加考试的ID
        List<String> examIds = new ArrayList<String>();

        //获取管理员domainCode和userName
        UserInfo userInfo = new UserInfo(new GetEnvironment().getInfo().getUserAccount());
        String domainCode = userInfo.getDomainCode();
        String userAccount = userInfo.getUserAccount();
        String sid = userInfo.getSid();

         //循环请求添加考试接口
        for(int i=0;i<exam.getExamCount();i++) {
            com.web.Request.Exam exam1 = new com.web.Request.Exam(exam.getExamType(),exam.getLanguageType(),exam.getExamPaper(),exam.getExamDiplomaId(),exam.getExamDiplomaName(),exam.getDatetimeStart(),exam.getDatetimeEnd(),userAccount,domainCode,sid);
            Request request = exam1.doRequest();

            //获取课程Id并记录
            String examId = JsonHelper.getValue(request.getResult(),"examId").toString();
            examIds.add(examId);
        }

        //发布考试
        if(!exam.getDomainCode().equals("") || !(exam.getDomainCode() == "")) {
            for(int i =0;i<examIds.size();i++) {
                ExamRelease examRelease = new ExamRelease(domainCode,exam.getDomainCode(),getRankIds(getAreaCodeByDomainCode(exam.getDomainCode())),examIds.get(i),userAccount,sid);
                examRelease.doRequest();
            }
        }

        // 重定向地址
        return "redirect:/exam/addExam";
    }



    /**
     * 根据单位Code获取单位的区域Code
     * @param domainCode
     * @return
     */
    public String getAreaCodeByDomainCode(String domainCode) {
        Request request = new Http().setUrl("/sss/service/courseService!doGetAreaCodeByDomainCode.do").setParam("domainCode",domainCode).get();
        String areaCode = JsonHelper.getValue(request.getResult(),"areaCode").toString().substring(0,2);
        return areaCode + "0000";
    }

    /**
     * 根据区域code获取rankId
     * @param areaCode
     * @return
     */
    public String getRankIds(String areaCode) {

        Request request = new Http().setUrl("/bss/service/rankService!doGetRankForPulish.do").setParam("areaCode",areaCode).get();
        String rankIds = "";
        String result = request.getResult();
        String[] ranks = result.split("},\\{");
        if(ranks.length == 1) {
            ranks[0] = ranks[0].substring(1);
            ranks[0] = ranks[0].substring(0,ranks[0].length()-1);
        }
        ranks[0] += "}";
        ranks[0] = ranks[0].substring(1);
        ranks[ranks.length-1] = "{" + ranks[ranks.length-1];
        ranks[ranks.length-1] = ranks[ranks.length-1].substring(0,ranks[ranks.length-1].length()-1);

        for(int i=1;i<ranks.length-1;i++) {
            ranks[i] = "{" + ranks[i] + "}";
        }

        for (int i=0;i<ranks.length;i++) {
            rankIds += JsonHelper.getValue(ranks[i],"id").toString() + ";";
        }
        rankIds = rankIds.substring(0,rankIds.length() - 1);
        return rankIds;

    }
}
