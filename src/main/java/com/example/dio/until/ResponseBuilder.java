package com.example.dio.until;

import com.example.dio.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

import java.util.List;

import static org.springframework.data.util.TypeUtils.type;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseStruture<T>> success(HttpStatus status, String message, T data) {
        ResponseStruture<T> structure = ResponseStruture.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(structure);
    }

    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(error);

    }


}

