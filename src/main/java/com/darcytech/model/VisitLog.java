package com.darcytech.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by GXL on 2016/7/26.
 */

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String source;

    @DateTimeFormat
    private Date time ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
