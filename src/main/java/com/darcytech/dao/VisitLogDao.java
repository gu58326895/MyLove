package com.darcytech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darcytech.model.VisitLog;

/**
 * Created by GXL on 2016/7/26.
 */
public interface VisitLogDao extends JpaRepository<VisitLog,Long> {
}
