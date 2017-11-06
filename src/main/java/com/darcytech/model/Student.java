package com.darcytech.model;

import java.io.Serializable;

/**
 * Created by guxiaoli on 19/05/2017.
 */
public class Student implements Serializable{

    private String name ;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
