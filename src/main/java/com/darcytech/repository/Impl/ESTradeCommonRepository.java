package com.darcytech.repository.Impl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.darcytech.model.ESTrade;

/**
 * Created by guxiaoli on 2017/2/22.
 */
public interface ESTradeCommonRepository  {


    Page<ESTrade> search(String a, String b, String c, String d, String buyerNick);

    Page<ESTrade> search2(String a, String b, String c, String d, String buyerNick);

    Page<ESTrade> search3(String a, String b, String c, String d, String buyerNick);
}
