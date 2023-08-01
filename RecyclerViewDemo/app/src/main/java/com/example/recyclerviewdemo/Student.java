package com.example.recyclerviewdemo;

public class Student {
    private int imageResource;
    private String name;
    private String role;

    public Student(int imageResource, String name, String role) {
        this.imageResource = imageResource;
        this.name = name;
        this.role = role;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
