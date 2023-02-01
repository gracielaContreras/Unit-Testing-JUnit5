package org.gcontreras.junit5app.ejemplos.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {

    private int gpa;
    private int age;
    private String fullName;

    public Student(int age,int gpa, String fullName) {
        this.gpa = gpa;
        this.age = age;
        this.fullName = fullName;
    }
}

