package com.student.demo.Entity;

import jakarta.persistence.*;
 
@Entity
public class Student {
 
    @Id
    private int id;
 
    private String name;
    private int age;
    private int marks;
 
    // Constructors
    public Student() {}
 
    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
 
    // Getters & Setters
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
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
 
    public int getMarks() {
        return marks;
    }
 
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
 