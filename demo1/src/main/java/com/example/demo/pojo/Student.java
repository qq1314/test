package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 4291632522488872854L;

    private Integer id;

    private String studentId;

    private String name;

    private Integer age;

    private String sex;

    private Date birthday;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}