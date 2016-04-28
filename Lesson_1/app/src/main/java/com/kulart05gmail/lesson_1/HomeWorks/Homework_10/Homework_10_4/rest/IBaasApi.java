package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest;


import com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models.LoginRequest;
import com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models.RegisterRequest;
import com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by al-ev on 11.04.2016.
 */
public interface IBaasApi {

//    @GET("profile/{id}/")
//    Call<Users> getProfile(@Path("id") String userId);

    @POST("v1/users/login")
    Call<Users> login(@Body LoginRequest loginRequest);

    @POST("v1/users/register")
    Call<Users> register(@Body RegisterRequest registerRequest);

}
