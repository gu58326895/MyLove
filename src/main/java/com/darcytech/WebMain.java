package com.darcytech;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebMain {

    public static void main(String[] args) {

        //不起web
        new SpringApplicationBuilder(WebMain.class).web(false).run(args);
        //SpringApplication.run(WebMain.class, args);
    }
}

