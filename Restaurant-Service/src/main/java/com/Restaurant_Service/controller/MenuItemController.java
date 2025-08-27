package com.Restaurant_Service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import com.Restaurant_Service.service.MenuItemService;
import com.Restaurant_Service.dto.MenuItemDTO;

import java.util.List;

@RestController
@RequestMapping("api/restaurant")
public class MenuItemController {
    
    @Autowired
    private MenuItemService service;

    @GetMapping("/allmenu")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        List<MenuItemDTO> result = service.getAllMenu();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/addMenu")
    public ResponseEntity<MenuItemDTO> addMenu(@Valid @RequestBody MenuItemDTO dto) {
        System.out.println("============[controller]==================[ "+dto.getRestaurantId()+" ]");
        MenuItemDTO item = service.addNewMenuItem(dto);
        return new ResponseEntity<>(item,HttpStatus.CREATED);
    }
}
