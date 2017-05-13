package com.darcytech.repository.Impl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.data.jpa.repository.Query;

import com.darcytech.model.ESTrade;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by guxiaoli on 2017/2/22.
 */
public class ESTradeRepositoryImpl implements ESTradeCommonRepository {



    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Page<ESTrade> search(String a, String b, String c, String d, String buyerNick) {

        Criteria criteria = new Criteria()
                .and(new Criteria("a").is(a))
                .and(new Criteria("buyerNick").contains("G"));


        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);

        criteriaQuery.setPageable(
                new PageRequest(0, 10)).addSort(
                new Sort(new Sort.Order(Sort.Direction.ASC, "b")));


        return elasticsearchTemplate.queryForPage(criteriaQuery,
                ESTrade.class);
    }


    public Page<ESTrade> search2(String a, String b, String c, String d, String buyerNick) {

        StringQuery stringQuery = new StringQuery(matchAllQuery().toString());

        return elasticsearchTemplate.queryForPage(stringQuery,
                ESTrade.class);
    }

    public Page<ESTrade> search3(String a, String b, String c, String d, String buyerNick) {

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();

        return elasticsearchTemplate.queryForPage(searchQuery,
                ESTrade.class);

    }

}
