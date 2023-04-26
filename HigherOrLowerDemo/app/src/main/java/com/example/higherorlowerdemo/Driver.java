package com.example.higherorlowerdemo;

public class Driver {
    public static void main(String[] args) {
        Person enes = new Person("Enes", 1.80, 19, 'M');
        enes.talk();
        System.out.println(enes.isMan());

        Person yakup = new Person("Yakup", 21, 'M');
        yakup.talk();

        Number number1 = new Number(5);
        System.out.println(number1.isPositive());

        Number number2 = new Number(-12);
        System.out.println(number2.isPositive());
    }
}
