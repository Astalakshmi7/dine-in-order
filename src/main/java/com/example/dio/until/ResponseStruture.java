package com.example.dio.until;

import lombok.*;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStruture <T>{


    private int status;
    private String message;
    private T data;



    public static <T> ResponseStruture<T> create (HttpStatus status,String message,T data){
        ResponseStruture <T> response =new ResponseStruture<>();
        response.status=status.value();
        response.message=message;
        response.data=data;
        return response;

    }
}



