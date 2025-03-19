package com.nepbrain.core.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JewelleryResponse {

    private boolean success;
    @JsonIgnore
    private HttpStatus httpStatus;
    private String code;
    private String message;
    private Object data;
    private String debugMessage;

}
