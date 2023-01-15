package com.ekibet.snowflakecrud.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponse {

    public static ResponseEntity<Object> getApiResponse(Boolean status, String message, Integer code, HttpStatus statusMsg, Object responseObject){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        map.put("statusCode", code);
        map.put("httpMessage", statusMsg);
        map.put("customerMessage", message);
        map.put("body", responseObject);
        return new ResponseEntity<>(map, statusMsg);
    }
}
