package com.example.dio.until;

import com.example.dio.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T>ResponseEntity<ResponseStruture<T>> success(HttpStatus status,String message,T data){
        ResponseStruture<T> struture =ResponseStruture.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(struture);
    }
}
