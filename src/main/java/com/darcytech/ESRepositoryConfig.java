package com.darcytech;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.darcytech.dao.UserDao;
import com.darcytech.repository.ESTradeRepository;

/**
 * Created by guxiaoli on 2017/2/21.
 */
@Configuration
@EnableElasticsearchRepositories(basePackageClasses = ESTradeRepository.class)
@EnableJpaRepositories(basePackageClasses = UserDao.class)
public class ESRepositoryConfig {



    @Autowired
    Client client;

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(){
        return new ElasticsearchTemplate(client);
    }


}
