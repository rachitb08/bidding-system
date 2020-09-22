package com.biddingclub.biddingsystem.exception;

import com.biddingclub.biddingsystem.constants.EnumMessage;
import com.biddingclub.biddingsystem.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler({RuntimeException.class})
    public ApiResponse handleRunTimeException(RuntimeException e) {
        return new ApiResponse(EnumMessage.INTERNAL_SERVER_ERROR.getErrorCode(), EnumMessage.INTERNAL_SERVER_ERROR.getErrorMsg());
    }
    @ExceptionHandler({BiddingException.class})
    public ApiResponse handleBiddingException(BiddingException be) {
        return new ApiResponse(be.getErrorCode(), be.getErrorMessage());
    }

}
