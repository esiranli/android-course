package com.example.higherorlowerdemo;

import java.util.ArrayList;
import java.util.List;

public class JavaLoops {
    public static void main(String[] args) {
        System.out.println("using while loop");
        int x = 1;
        while (x <= 10) {
            System.out.println(x);
            x++; // x = x + 1;
        }

        System.out.println("using for loop");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("Enes's solution:");
        for (int i = 2; i <= 10; i = i + 2) {
            System.out.println(i);
        }

        System.out.println("Ahmet's solution:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(3 * i);
        }

        // foreach
        List<String> countryList = new ArrayList<String>();
        countryList.add("Turkey");
        countryList.add("Germany");
        for (String country: countryList) {
            if (country.startsWith("G")) {
                System.out.println(country);
            }
        }

        // for each by using indexed method
        for (int i = 0; i < countryList.size(); i++) {
            String country = countryList.get(i);
            if (country.equals("TR")) {
                //String phoneCode = "+90";
                System.out.println("As bayraklari!");
            }
        }
    }
}
