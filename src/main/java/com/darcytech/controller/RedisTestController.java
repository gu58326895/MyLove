package com.darcytech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guxiaoli on 2017/2/8.
 */
@Controller
public class RedisTestController {



    @Autowired
    RedisTemplate<String, String> redisTemplate;



    @RequestMapping("/redisTest")
    public void redisTest(){

        redisTemplate.boundValueOps("a").set("wazqy");

    }


}
