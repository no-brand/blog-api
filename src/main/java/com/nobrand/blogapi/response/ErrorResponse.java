package com.nobrand.blogapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;
    private Map<String, String> validations = new HashMap<>();

    public void putValidation(String key, String value) {
        this.validations.put(key, value);
    }

}
