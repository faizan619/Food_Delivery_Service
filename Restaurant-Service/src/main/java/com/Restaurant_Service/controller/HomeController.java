package com.Restaurant_Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class HomeController {

    @GetMapping("restaurant")
    public String getTestMessage(){
        return "This is the Restaurant Service";
    }
}