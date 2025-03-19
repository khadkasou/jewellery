package com.nepbrain.core.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    protected boolean success;
    @JsonIgnore
    protected HttpStatus httpStatus;
    protected String message;
    protected String code;
}
