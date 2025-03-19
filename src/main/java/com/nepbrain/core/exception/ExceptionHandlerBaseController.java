package com.nepbrain.core.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.nepbrain.core.builder.ServiceResponseBuilder;
import com.nepbrain.core.payload.JewelleryResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.method.ParameterErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import javax.naming.AuthenticationException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ExceptionHandlerBaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerBaseController.class);
    @ExceptionHandler(JewelleryException.class)
    public ResponseEntity<JewelleryResponse> handleJewelleryException(JewelleryException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus())
                .body(ServiceResponseBuilder.buildFailureResponse(e));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JewelleryResponse> handleException(Exception e) {
        log.error(e.getMessage());
        if (e.getCause() instanceof JewelleryException jewelleryException) {
            return ResponseEntity.status(jewelleryException.getHttpStatus())
                    .body(ServiceResponseBuilder.buildFailureResponse(jewelleryException));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ServiceResponseBuilder.buildUnknownFailureResponse(e));
    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<JewelleryResponse> handleException(HandlerMethodValidationException e) {
        log.error(e.getMessage());
        List<ParameterErrors> bindingResult = e.getBeanResults();
        Map<String, List<String>> data = bindingResult.stream()
                .flatMap(result -> result.getFieldErrors().stream())
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())
                ));

        JewelleryResponse jewelleryResponse = new JewelleryResponse();
        jewelleryResponse.setSuccess(false);
        jewelleryResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        jewelleryResponse.setData(data);

        return ResponseEntity.badRequest().body(jewelleryResponse);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JewelleryResponse> handleException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, List<String>> errors = bindingResult.getAllErrors().stream().collect(Collectors.groupingBy(
                error -> (error instanceof FieldError fieldError) ? fieldError.getField() : ((ObjectError) error).getObjectName(),
                Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())));

        JewelleryResponse jewelleryResponse = new JewelleryResponse();
        jewelleryResponse.setSuccess(false);
        jewelleryResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        jewelleryResponse.setData(errors);
        return ResponseEntity.badRequest().body(jewelleryResponse);
    }


    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<JewelleryResponse> handleResourceNotFoundException(NoResourceFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ServiceResponseBuilder.buildUnknownFailureResponse(e));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<JewelleryResponse> handleAuthenticationException(final AuthenticationException e, final HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ServiceResponseBuilder.buildUnknownFailureResponse(e));
    }

    @ExceptionHandler(WebClientResponseException.Forbidden.class)
    public ResponseEntity<JewelleryResponse> handleNotAuthorizedException(final WebClientResponseException.Forbidden e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ServiceResponseBuilder.buildUnknownFailureResponse(e));
    }

}
