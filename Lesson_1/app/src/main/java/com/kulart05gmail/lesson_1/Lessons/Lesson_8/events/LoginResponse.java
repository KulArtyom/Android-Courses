package com.kulart05gmail.lesson_1.Lessons.Lesson_8.events;


/**
 * Created by KulArtyom on 15.04.2016.
 */
public class LoginResponse extends BaseResponse {

    public LoginResponse() {
        super();
    }


    public LoginResponse(boolean isError, String errormessage) {
        super(isError, errormessage);
    }


}
