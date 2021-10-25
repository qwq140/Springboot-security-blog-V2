package com.cos.springbootthymleaf.handler;


import com.cos.springbootthymleaf.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public CMRespDto<?> illegalArgument(Exception e){
        return new CMRespDto<>(-1, e.getMessage(),null);
    }
}
