package com.darcytech.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.darcytech.model.ESTrade;
import com.darcytech.repository.Impl.ESTradeCommonRepository;


public interface ESTradeRepository extends ElasticsearchRepository<ESTrade,Long>, ESTradeCommonRepository {

    ESTrade findByTid(Long tid);

}


