package com.darcytech.model;

import java.io.Serializable;

/**
 * Created by guxiaoli on 19/05/2017.
 */
public class Teacher implements Serializable{

    private String name;

    private String age;

    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
