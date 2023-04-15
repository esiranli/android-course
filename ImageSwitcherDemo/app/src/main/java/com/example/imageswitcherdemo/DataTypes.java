package com.example.imageswitcherdemo;

import java.util.*;

public class DataTypes {
    public static void main(String[] args) {
        //Array
         String[] names = new String[]{"Hakan", "Bilal", "Yakup", "Ahmet", "Emre"};
         System.out.println(names.length);
         int[] ages = new int[5];
         ages[0] = 16;

        //ArrayList
        List<String> countryList = new ArrayList<String>();
        countryList.add("Turkey");
        countryList.add("Germany");
        // countryList.remove(0);
        System.out.println(countryList);
        System.out.println(countryList.size());

        //Map
        Map map = new HashMap();
        map.put("DE", "German");
        map.put("EN", "English");
        map.put("TR", "Turkish");
        map.remove("TR");
        System.out.println(map);
        System.out.println(map.size());

        //if else
        //1.example
        int myAge = 20;
        if (myAge > 18) {
            System.out.println("I am over 18");
        } else {
            System.out.println("I am under 18");
        }

        //2.example
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(9);
        numbers.add(9);

        if (numbers.get(0) > numbers.get(1)) {
            System.out.println("First number is greater");
        } else if (numbers.get(0) < numbers.get(1)) {
            System.out.println("Second number is greater");
        } else {
            System.out.println("Two numbers are equal");
        }
    }
}
