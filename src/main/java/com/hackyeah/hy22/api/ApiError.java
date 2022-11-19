package com.hackyeah.hy22.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    private String errorMessage;
    private HttpStatus errorCode;
}
