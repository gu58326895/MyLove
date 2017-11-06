package com.darcytech.model;

/**
 * Created by guxiaoli on 19/05/2017.
 */
public class Father {


    private Teacher teacher;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {

        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
