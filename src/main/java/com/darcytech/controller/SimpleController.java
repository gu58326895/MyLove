package com.darcytech.controller;

import com.darcytech.dao.VisitLogDao;
import com.darcytech.model.User;
import com.darcytech.model.VisitLog;
import com.darcytech.service.VisitLogService;
import com.darcytech.web.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darcy on 2015/12/30.
 */

@Controller
public class SimpleController {

    @Autowired
    VisitLogService visitLogService;


    @Autowired
    private JavaMailSender mailSender;


    @RequestMapping("/send")
    public String send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1179942487@qq.com");//发送者.
        message.setTo("1009388154@qq.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
        return "";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        String from = request.getHeader("user-agent");
        if (from.contains("Android")) {
            from = "Android移动客户端";
        } else if (from.contains("iPhone")) {
            from = "iPhone移动客户端";

        } else if (from.contains("iPad")) {
            from = "iPad客户端";
        } else if (from.contains("Windows ")) {
            from = "windows客户端";
        } else {
            from = "其他客户端";
        }
        VisitLog vl = new VisitLog();
        vl.setTime(new Date());
        vl.setSource(from);
        visitLogService.save(vl);
        return "redirect:/snow.html";
    }

    @RequestMapping("/hhh")
    public String heart() {
        return "redirect:/heart.html";
    }

    @RequestMapping("ttt")
    public String test() {
        return "redirect:/test.html";
    }

    @RequestMapping("abc")
    public ModelAndView a() {
        ModelAndView m = new ModelAndView();
      /*  System.out.println(name);
        m.addObject("name", name);
        m.addObject("age", age);*/
        return m;
    }

    @RequestMapping("newTrade")
    public ModelAndView newTrade() {
        ModelAndView m = new ModelAndView();
      /*  System.out.println(name);
        m.addObject("name", name);
        m.addObject("age", age);*/
        return m;
    }

    @RequestMapping("password")
    public ModelAndView password(String length, String isUpperCase, String isPunctuation) {
        int mylength;

        ModelAndView m = new ModelAndView();
        Pattern p = Pattern.compile("\\d{1,2}");
        if (p.matcher(length).matches()) {
            mylength = Integer.parseInt(length);
        } else {
            mylength = 6;
        }
        boolean myisUpperCase = "true".equals(isUpperCase);
        boolean myisPunctuation = "true".equals(isPunctuation);

        m.addObject("password", RandomString.genRandomNum(mylength, myisUpperCase, myisPunctuation));
        return m;
        //writer.write("您得到的密码是："+RandomString.genRandomNum(length,isUpperCase,isPunctuation));
    }



    @RequestMapping("/writeLog")
    @ResponseBody
    public Object writeLog(String result) {
        VisitLog vl = new VisitLog();
        vl.setTime(new Date());
        vl.setMemo(result);
        return visitLogService.save(vl);
    }

    @RequestMapping("/socket")
    public Object socket(){
        return "redirect:/sendMessage.html";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }



}
