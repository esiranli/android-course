package com.example.imageswitcherdemo;

public class JavaTypes {
    public int age = 16;
    public double ageAverage = 0.0;
    public String name = "Ahmet";

    public static void main(String[] args) {
        // HelloWorld helloworld = new HelloWorld();
        // helloworld.setAge(19, "Bilal's age:");
        // System.out.println("First name: " + helloworld.name);
        // helloworld.changeName();
        String myName = "Bilal";
        System.out.println(myName.length()); //this outputs a text as a line

    }

    public void setAge(int age, String message) {
        this.age = age;
        System.out.println(message + age);
    }

    public void changeName() {
        this.name = "Yakup";
        System.out.println("Changed name: " + name);
    }
}

class OtherClass {
    public String message = "Bilal's age: ";

    public OtherClass() {
        JavaTypes world = new JavaTypes();
        world.age = 19;
        System.out.println(message + world.age);
    }
}
