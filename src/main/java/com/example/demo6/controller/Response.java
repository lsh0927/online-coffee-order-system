package com.example.demo6.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> {
    //generic하게 등록하여 다양한 데이터를 받을수 있도록
    private final HttpStatus statusCode;
    // 성공 여부를 판단할 코드
    private final String message;
    private final T data;

    public Response(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    //static 메서드로 성공,실패
    public static <T> Response<T> success(T data){
        return  new Response<>(HttpStatus.OK,"Success",data);
    }
    public static <T> Response<T> fail(String errorMessage){
        return  new Response<>(HttpStatus.INTERNAL_SERVER_ERROR,errorMessage,null);
    }
}
