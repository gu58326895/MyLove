package com.darcytech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcytech.dao.VisitLogDao;
import com.darcytech.model.VisitLog;
import com.darcytech.service.VisitLogService;

/**
 * Created by GXL on 2016/7/28.
 */

@Service
public class VisitLogServiceImpl implements VisitLogService{

    @Autowired
    VisitLogDao visitLogDao;


    @Override
    public VisitLog save(VisitLog visitLog) {
        return visitLogDao.save(visitLog);
    }

}
