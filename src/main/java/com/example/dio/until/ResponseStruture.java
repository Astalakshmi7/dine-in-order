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

    /**
     * Creates a new {@Link ResponseStructure} instance with the given status, message, and data.
     *
     * @param status  The HTTP status of the response.
     * @param message The message describing the response.
     * @param data    The response data.
     * @param <T>     The type of the response data.
     * @return A new {@Link ResponseStructure} instance with the provided values.
     */

    public static <T> ResponseStruture<T> create (HttpStatus status,String message,T data){
        ResponseStruture <T> response =new ResponseStruture<>();
        response.status=status.value();
        response.message=message;
        response.data=data;
        return response;

    }
}



