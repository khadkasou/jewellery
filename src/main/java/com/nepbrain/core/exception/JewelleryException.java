package com.nepbrain.core.exception;

import com.fasterxml.jackson.databind.util.ExceptionUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;

@Getter
@Setter
public class JewelleryException extends Exception{

    private final String code;
    private final String debugMessage;
    private final HttpStatus httpStatus;

    public JewelleryException(String code){
        this.code = code;
        this.debugMessage = "";
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public JewelleryException(String code, List<String> param){
        this.code = code;
        this.debugMessage = "";
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public JewelleryException(String code, String message){
        super(message);
        this.code = code;
        this.debugMessage = "";
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public JewelleryException(String code, HttpStatus httpStatus){
        this.code = code;
        this.debugMessage = "";
        this.httpStatus = httpStatus;
    }

    public JewelleryException(String code, Throwable throwable) {
        super(throwable.getMessage());
        this.code = code;
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        this.debugMessage = ExceptionUtils.getStackTrace(throwable);
    }

    public JewelleryException(String code, String message, HttpStatus httpStatus){
        super(message);
        this.code = code;
        this.debugMessage = "";
        this.httpStatus = httpStatus;
    }

    public JewelleryException(String code, HttpStatus httpStatus, String debugMessage){
        this.code = code;
        this.debugMessage = debugMessage;
        this.httpStatus = httpStatus;
    }
}
