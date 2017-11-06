package com.darcytech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.darcytech.dao.VisitLogDao;
import com.darcytech.model.VisitLog;

@Component
public class VisitLogService {

    @Autowired
    VisitLogDao visitLogDao;


    public VisitLog save(VisitLog visitLog) {
        return visitLogDao.save(visitLog);
    }
}
