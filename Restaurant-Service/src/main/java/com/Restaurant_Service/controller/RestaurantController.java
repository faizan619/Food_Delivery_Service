package com.Restaurant_Service.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.Restaurant_Service.dto.RestaurantDTO;
// import com.Restaurant_Service.model.Restaurant;
import com.Restaurant_Service.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurant() {
        List<RestaurantDTO> restaurant = service.getAllRestaurant();
        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurantDetails(@PathVariable int id) {
        RestaurantDTO res = service.getRestaurantById(id);
        if(res != null) {
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant with ID " + id + " not found."); 
        }
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> saveRestaurantData(@Valid @RequestBody RestaurantDTO dto) {
        RestaurantDTO data = service.saveRestaurant(dto);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<RestaurantDTO>> getBulkRestaurant(@Valid @RequestBody List<RestaurantDTO> dto) {
        List<RestaurantDTO> allData = service.saveAllRestaurant(dto);
        return new ResponseEntity<>(allData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurantDeta(@Valid @RequestBody RestaurantDTO dto, @PathVariable int id) {
        RestaurantDTO data = service.updateRestaurant(dto,id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurantData(@PathVariable int id) {
        String message = service.deleteById(id);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }
}
