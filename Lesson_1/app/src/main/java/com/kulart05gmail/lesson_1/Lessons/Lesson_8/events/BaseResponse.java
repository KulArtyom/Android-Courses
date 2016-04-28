package com.kulart05gmail.lesson_1.Lessons.Lesson_8.events;

/**
 * Created by KulArtyom on 15.04.2016.
 */
public class BaseResponse {
    private boolean isError;
    private String errorMessage;

    public BaseResponse() {
    }

    public BaseResponse(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
