package org.gcontreras.junit5app.ejemplos.models;

public class Student {

    private int gpa;
    private int age;
    private String fullName;

    public Student(int age,int gpa, String fullName) {
        this.gpa = gpa;
        this.age = age;
        this.fullName = fullName;
    }

    public int getGpa() {
        return gpa;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

