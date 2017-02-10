package com.darcytech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guxiaoli on 2017/2/9.
 */

@Controller
public class LoginController {




    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
