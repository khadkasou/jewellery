package com.nepbrain.core.builder;


import com.nepbrain.core.exception.JewelleryException;
import com.nepbrain.core.payload.JewelleryResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class ServiceResponseBuilder {

    private ServiceResponseBuilder() {}

    public  static JewelleryResponse buildSuccessResponse(Object o){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.TRUE);
        response.setData(o);
        return response;
    }
    public static JewelleryResponse buildSuccessResponse(String message, Object o){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.TRUE);
        response.setData(o);
        response.setMessage(message);
        return response;
    }
    public static JewelleryResponse buildSuccessResponse(String message){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.TRUE);
        response.setMessage(message);
        return response;
    }

    public static JewelleryResponse buildFailureResponse(JewelleryException exception){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.FALSE);
        response.setCode(exception.getCode());
        response.setMessage(exception.getMessage());
        return response;
    }

    public static JewelleryResponse buildFailureResponse(String message){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.FALSE);
        response.setMessage(message);
        return response;
    }

    public static JewelleryResponse buildUnknownFailureResponse(Exception exception){
        JewelleryResponse response = new JewelleryResponse();
        response.setSuccess(Boolean.FALSE);
        response.setCode("000000");
        response.setMessage(exception.getMessage());
        response.setDebugMessage(ExceptionUtils.getStackTrace(exception));
        return response;

    }
}
