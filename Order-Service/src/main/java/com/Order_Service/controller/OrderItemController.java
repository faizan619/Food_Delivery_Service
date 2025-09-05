package com.Order_Service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.Order_Service.dto.OrderItemDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.Order_Service.service.OrderItemService;


@RestController
@RequestMapping("/api/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService service;
    
    @GetMapping("/allitems")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        List<OrderItemDTO> order = service.viewAllItems();
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    
}
