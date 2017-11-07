package com.darcytech.controller;

import com.darcytech.model.VisitLog;
import com.darcytech.service.VisitLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


@Controller
public class SimpleController {

    @Autowired
    VisitLogService visitLogService;

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


}
