package com.example.dio.until;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class ResponseStruture <T>{


    private int status;
    private String message;
    private T data;
}



