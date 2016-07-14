package com.darcytech.web;


import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;


public class PasswordServlet extends HttpServlet {

    public static final String DEFAULT_LANGUAGE = "EN-US";
    private int length;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acceptLanguage = req.getHeader("Accept-Language");
        if (acceptLanguage == null) {
            acceptLanguage = DEFAULT_LANGUAGE;
        } else {
            acceptLanguage = acceptLanguage.toUpperCase();
        }
        PrintWriter writer = resp.getWriter();
        if (acceptLanguage.contains(DEFAULT_LANGUAGE)) {
            writer.write("this is an english response");
        } else {
            writer.write("this is an english response");
        }
       // req.getCookies();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("DOPOST");
        Pattern p = Pattern.compile("\\d{1,2}");
        if(p.matcher(req.getParameter("length")).matches()){
            length=Integer.parseInt(req.getParameter("length"));
        }else{
            length = 6 ;
        }
        boolean isUpperCase =  "true".equals(req.getParameter("isUpperCase"));
        boolean isPunctuation = "true".equals(req.getParameter("isPunctuation"));
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("您得到的密码是："+RandomString.genRandomNum(length,isUpperCase,isPunctuation));
    }
}
