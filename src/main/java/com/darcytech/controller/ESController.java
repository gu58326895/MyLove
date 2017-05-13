package com.darcytech.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darcytech.dao.TradeDao;
import com.darcytech.dao.VisitLogDao;
import com.darcytech.repository.ESTradeRepository;
import com.darcytech.model.ESTrade;

/**
 * Created by guxiaoli on 2017/2/17.
 */

@RestController
@RequestMapping(value = "/es/")
public class ESController {




    @Autowired
    private ESTradeRepository tradeRepository;

    @Autowired
    private TradeDao tradeDao;

    @Autowired
    private VisitLogDao visitLogDao;

    @RequestMapping(value = "/count")
    public Object test()
    {
        return tradeRepository.count();
    }


    @RequestMapping(value = "/save")
    public void save(Long tid, String a,String b, String c, String d, String buyerNick)
    {
        ESTrade trade = new ESTrade();

        trade.setA(a);
        trade.setB(b);
        trade.setC(c);
        trade.setD(d);
        trade.setE("e");
        trade.setF("f");
        trade.setG("g");
        trade.setCreatedTime(new Date());
        trade.setBuyerNick(buyerNick);
        trade.setSeller_nick("FCX");
        trade.setTid(tid);
        tradeRepository.save(trade);
        tradeDao.save(trade);
    }


    @RequestMapping(value = "/get")
    public Object get(Long tid)
    {
        return tradeRepository.findByTid(tid);
    }

    @RequestMapping(value = "/get0")
    public Object get0(Long tid)
    {
        return tradeDao.findByA("a");
    }

    @RequestMapping(value = "/delete")
    public void delete()
    {
        ESTrade trade = tradeRepository.findByTid(123L);
        tradeRepository.delete(trade);
    }


    @RequestMapping(value = "/search")
    public Object search(String a, String b, String c, String d,String buyerNick)
    {
        return tradeRepository.search(a,b,c,d,buyerNick);
    }

    @RequestMapping(value = "/search2")
    public Object search2(String a, String b, String c, String d,String buyerNick)
    {
        return tradeRepository.search2(a,b,c,d,buyerNick);
    }

    @RequestMapping(value = "/search3")
    public Object search3(String a, String b, String c, String d,String buyerNick)
    {
        return tradeRepository.search3(a,b,c,d,buyerNick);
    }






}
