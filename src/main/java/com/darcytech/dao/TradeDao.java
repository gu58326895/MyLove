package com.darcytech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darcytech.model.ESTrade;

/**
 * Created by guxiaoli on 2017/2/22.
 */
public interface TradeDao extends JpaRepository<ESTrade,Long>{



    ESTrade findByA(String a);

    ESTrade findByTid(Long tid);

}
