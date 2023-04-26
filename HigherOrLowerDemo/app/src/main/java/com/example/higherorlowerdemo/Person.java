package com.example.higherorlowerdemo;

public class Person {
    // Variables
    private String name;
    private double height;
    private int age;
    private char sex; // "M", "W", "D"

    // Constructor
    public Person(String name, double height, int age, char sex) {
        this(name, age, sex); // it is the same with the next three lines
//        setName(name);
//        setAge(age);
//        setSex(sex);
        setHeight(height);

    }
    public Person(String name, int age, char sex) {
        setName(name);
        setAge(age);
        setSex(sex);
    }

    // Behaviours
    public void talk() {
        System.out.println("My name is " + name + ". I am " + age + " years old");
    }

    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Helper method
    public boolean isMan() {
        if (sex == 'M') {
            return true;
        } else {
            return false;
        }
    }
}
