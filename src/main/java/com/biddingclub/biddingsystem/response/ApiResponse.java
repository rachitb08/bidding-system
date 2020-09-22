package com.biddingclub.biddingsystem.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private int statusCode;
    private String message;
    private Object responseData;

    public ApiResponse(int statusCode, String message, Object responseData) {
        this.statusCode = statusCode;
        this.message = message;
        this.responseData = responseData;
    }

    public ApiResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
