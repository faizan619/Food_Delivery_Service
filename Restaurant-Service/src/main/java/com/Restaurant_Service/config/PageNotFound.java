package com.Restaurant_Service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageNotFound implements ErrorController {
    
    @RequestMapping("/page-not-found")
    public ResponseEntity<Map<String, String>> handleError() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Page not found!");
        response.put("path", "/error");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
