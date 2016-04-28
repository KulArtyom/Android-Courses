package com.kulart05gmail.lesson_1.Lessons.Lesson_8.network.api;


import com.kulart05gmail.lesson_1.Lessons.Lesson_8.events.LoginRequest;
import com.kulart05gmail.lesson_1.Lessons.Lesson_8.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;


/**
 * Created by KulArtyom on 11.04.2016.
 */
public interface IBaasApi {

    @POST("v1/users/login")
    Call<Users> login(@Body LoginRequest loginRequest);


}
