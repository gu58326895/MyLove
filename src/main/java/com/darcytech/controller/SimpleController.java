package com.darcytech.controller;

import com.darcytech.dao.VisitLogDao;
import com.darcytech.model.User;
import com.darcytech.model.VisitLog;
import com.darcytech.service.VisitLogService;
import com.darcytech.web.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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



    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        String from = request.getHeader("user-agent");
        if(from.contains("Android")) {
            from = "Android移动客户端";
        } else if(from.contains("iPhone")) {
            from = "iPhone移动客户端";

        }  else if(from.contains("iPad")) {
            from ="iPad客户端";
        }  else if(from.contains("Windows ")){
            from = "windows客户端";
        }  else{
            from ="其他客户端";
        }
        VisitLog vl = new VisitLog();
        vl.setTime(new Date());
        vl.setSource(from);
        visitLogService.save(vl);
        return "redirect:/snow.html";
    }

    @RequestMapping("/dateTest")
    public void dateTest(User user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getTime());

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

        m.addObject("password", RandomString.genRandomNum(mylength,myisUpperCase,myisPunctuation));
        return m;
        //writer.write("您得到的密码是："+RandomString.genRandomNum(length,isUpperCase,isPunctuation));
    }

  /*  @RequestMapping("sanbox")
    public ModelAndView sanbox()
    {
        ModelAndView m = new ModelAndView();
        String appKey="test";
        String appSecret="test";
        String serverUrl = "http://gw.api.tbsandbox.com/router/rest";
        *//**创建client**//*
        DefaultTaobaoClient client = new DefaultTaobaoClient(serverUrl , appKey , appSecret, "json");
        UserSellerGetRequest req = new UserSellerGetRequest();
        *//**设置API业务入参**//*
        req.setFields("nick,email");
        req.setNick("sandbox_c_1");
        UserSellerGetResponse resp = client.execute(req );
        *//**正常请求，获取用户信息，由于email是需要用户授权才能获取，因此返回的信息中不包含emaill信息**//*
        System.out.println(resp.getBody());

        *//**传入用户授权的sessionkey， 可获取用户 的email**//*
        resp = client.execute(req, "6101813112fbded1142381ece45b633a381c53976144a932074082786");
        System.out.println(resp.getBody());

        *//**传入不存在的nick ，对错误进行处理****//*
        req.setNick("sandbox_nouser");
        resp = client.execute(req);

        if(resp.isSuccess()) {
            System.out.println(resp.getBody());
        } else {
            *//**如果subCode 以isp开头，可重试，否则是由于业务错误，请不要重试。***//*
            if(resp.getSubCode() != null && resp.getSubCode().startsWith("isp"))
                resp = client.execute(req);
            else
                System.out.println(resp.getBody());
        }
        return m ;
    }*/

    @RequestMapping("/test")
            public void test(User user)
    {
        System.out.println(user.getFirstName()+"<<<---->>>"+user.getLastName());
    }
}
