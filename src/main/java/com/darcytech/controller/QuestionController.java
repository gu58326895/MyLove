package com.darcytech.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.darcytech.model.Student;
import com.darcytech.model.Teacher;
import com.darcytech.model.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by guxiaoli on 24/05/2017.
 */
@Controller
public class QuestionController {

    /**
     *
     * teacher.name
     * teacher.age
     * student.name
     * student.age
     *
     */

    public Object test(Teacher teacher, Student student){

        return null;
    }




    public Object trade(){
        Trade trade = new Trade();
        trade.setUserId(11878123L);
        trade.setTid(91234444L);
        trade.setSellerNick("q奇园");
        return longToString(trade);
    }



    private Map<String, Object> longToString(Trade trade) {
        Map<String, Object> result = new ObjectMapper().convertValue(trade, Map.class);
        result.put("tid", String.valueOf(trade.getTid()));
        return result;
    }


}
