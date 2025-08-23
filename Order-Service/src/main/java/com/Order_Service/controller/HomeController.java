package com.Order_Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class HomeController {

    @GetMapping("order")
    public String getTestMessage(){
        return "This is the Order Service";
    }
}