package com.darcytech.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darcytech.annotation.MyData;
import com.darcytech.annotation.StringTid;
import com.darcytech.model.Student;
import com.darcytech.model.Teacher;
import com.darcytech.model.Trade;
import com.darcytech.model.Father;
import com.darcytech.model.vo.PageVO;

/**
 * Created by darcy on 2016/1/18.
 */

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/test1",  method = RequestMethod.POST)
    @ResponseBody
    public void test1(@MyData Teacher teacher, @MyData Student student) {
        System.out.println("test");
    }


    @RequestMapping(value = "/test2",  method = RequestMethod.POST)
    public void test2(@RequestBody Father vo) {
        Student student = vo.getStudent();
        Teacher teacher = vo.getTeacher();
    }


    @RequestMapping(value = "/test3")
    @StringTid
    public Object test3(){
        Trade trade = new Trade();
        trade.setUserId(11878123L);
        trade.setTid(91234444L);
        trade.setSellerNick("q奇园");
        return trade;
    }


    @RequestMapping("/list")
    @ResponseBody
    public Object list() {
        Trade trade = new Trade();
        trade.setUserId(11878123L);
        trade.setTid(91234444L);
        trade.setSellerNick("q奇园");
        return trade;
    }



    @RequestMapping("/page")
    public void page(Pageable page){
        System.out.println(page.getPageSize());
        System.out.println(page.getPageNumber());
    }


    @RequestMapping("/badPage")
    public void badPage(PageVO pageVO){
        int page = pageVO.getPage() <=1  ? 0 :  pageVO.getPage() -1;
        int pageSize = pageVO.getPageSize();
    }






}
