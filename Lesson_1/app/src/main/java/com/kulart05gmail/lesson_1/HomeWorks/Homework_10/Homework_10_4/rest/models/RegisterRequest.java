package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models;

/**
 * Created by al-ev on 15.04.2016.
 */
public class RegisterRequest {
    private String email;
    private String password;
    private String name;

    public RegisterRequest(String login, String password, String name) {
        this.email = login;
        this.password = password;
        this.name = name;
    }
}
