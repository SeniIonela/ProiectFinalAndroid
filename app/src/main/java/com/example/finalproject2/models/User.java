package com.example.finalproject2.models;

public class User {

    public  int id;
    public String name;
    public String email;
    public String number;
    public int created_at;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
