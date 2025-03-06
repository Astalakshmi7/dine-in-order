package com.example.dio.until;
/**
 * Represents a simple error response structure.
 * This class is used to encapsulate error details, including
 * the type of error, HTTP status code, and an error message.
 */
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
/**
 * Class representing a simple error response.
 */
@Getter
@SuperBuilder
public class SimpleErrorResponse {
    /**
     * Type of the error.
     */
    private String type;
    /**
     * HTTP status code associated with the error (e.g., 404 for Not Found).
     */
    private int status;     //404
    /**
     * Detailed error message describing the issue (e.g., "Failed to update the user, the user is not found by the given ID").
     */
    private String message; //failed to update the user,the user is not found by the given id
}
