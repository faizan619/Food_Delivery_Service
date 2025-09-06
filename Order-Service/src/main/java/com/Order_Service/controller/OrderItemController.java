package com.Order_Service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.Order_Service.dto.OrderItemDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Order_Service.service.OrderItemService;


@RestController
@RequestMapping("/api/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService service;
    
    @GetMapping("/items")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        List<OrderItemDTO> order = service.viewAllItems();
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<OrderItemDTO> addOrderItemsDetails(OrderItemDTO dto) {
        return new ResponseEntity<>(service.addOrdersItems(dto),HttpStatus.OK);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateItemDetail(@RequestBody OrderItemDTO dto, @PathVariable int id) {
        OrderItemDTO order = service.updateItem(dto,id);
        if(order != null) {
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        else{
            String msg = "Unable to Find the Data in our record!";
            return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteItemDetails(@PathVariable int id) {
        return new ResponseEntity<>(service.deleteItem(id),HttpStatus.OK);
    }
    
}
