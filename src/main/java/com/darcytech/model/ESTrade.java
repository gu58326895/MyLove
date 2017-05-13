package com.darcytech.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by guxiaoli on 2017/2/17.
 */
@Document(indexName = "poseidon", type = "trade", shards = 1, replicas = 0, refreshInterval = "-1")
@Entity
public class ESTrade {


    @Id
    @javax.persistence.Id
    private Long tid;

    private String seller_nick;

    private String buyerNick;


    @Field(format = DateFormat.date_time,type= FieldType.Object,index= FieldIndex.no)
    private Date createdTime;

    private String a;

    private String b;

    private String c;

    private String d;

    private String e;

    private String f;

    private String g;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getSeller_nick() {
        return seller_nick;
    }

    public void setSeller_nick(String seller_nick) {
        this.seller_nick = seller_nick;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }
}
