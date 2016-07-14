package com.darcytech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by darcy on 2016/1/18.
 */

@Controller
@RequestMapping("trades")
public class TestController {

    @RequestMapping("list")
    public void list(Model model) {

       model.addAttribute("name","guxiaoli");
    }
}
