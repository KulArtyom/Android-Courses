package com.kulart05gmail.lesson_1.HomeWorks.Homework_8;

public class RegisterRequest {

    private String email;
    private String password;
    private String name;

    public RegisterRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
