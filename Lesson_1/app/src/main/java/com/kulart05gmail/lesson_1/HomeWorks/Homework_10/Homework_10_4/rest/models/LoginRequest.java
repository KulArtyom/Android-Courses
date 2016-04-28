package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models;

/**

 * Created by al-ev on 13.04.2016.
 */
public class LoginRequest {
    private String login;
    private String password;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
