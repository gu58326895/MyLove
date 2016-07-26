package com.darcytech;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.darcytech.service.UserService;
import com.darcytech.service.UserServiceImpl;
import com.darcytech.service.UserServiceImpl2;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class WebMain {

    public static void main(String[] args) {

       // UserService userService = new UserServiceImpl2();

       // userService.getUser();
        SpringApplication.run(WebMain.class, args);
    }
}

