package com.darcytech.schedual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.darcytech.service.Free115Service;

@Component
public class WebScheduled {


    @Autowired
    Free115Service free115Service;


    //@Scheduled(fixedDelay = 1000L * 60)
    public void dispatch115(){
        free115Service.dispatch();
    }
}
