package com.Customer_Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class HomeController {

    @GetMapping("customer")
    public String getTestMessage(){
        return "This is the Customer Service";
    }
}