package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;

    public User(int id, String name, String username, String email, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " " + email;
    }
}

//{
//        "id": 1,
//        "name": "Leanne Graham",
//        "username": "Bret",
//        "email": "Sincere@april.biz",
//        "address": {
//        "street": "Kulas Light",
//        "suite": "Apt. 556",
//        "city": "Gwenborough",
//        "zipcode": "92998-3874",
//        "geo": {
//        "lat": "-37.3159",
//        "lng": "81.1496"
//        }
//        },
//        "phone": "1-770-736-8031 x56442",
//        "website": "hildegard.org",
//        "company": {
//        "name": "Romaguera-Crona",
//        "catchPhrase": "Multi-layered client-server neural-net",
//        "bs": "harness real-time e-markets"
//        }
//        }