package com.Restaurant_Service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant_Service.dto.RestaurantDTO;

@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {
    
    @GetMapping
    public String getMessage(){
        return "hello world";
    }
    // public List<RestaurantDTO> getAllRestaurant() {
        
    // }
}
