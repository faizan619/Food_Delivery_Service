package com.Order_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Order_Service.config.OrderStatus;
import com.Order_Service.dto.OrderDTO;
import com.Order_Service.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(@RequestParam(required = false) OrderStatus status){
        if(status != null) {
            List<OrderDTO> filterStatus = service.getAllOrdersByStatus(status);
            return new ResponseEntity<>(filterStatus,HttpStatus.OK);
        }

        List<OrderDTO> order = service.getAllOrder();
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetails(@PathVariable int id) {
        OrderDTO order = service.getOrderDetails(id);
        if(order != null) {
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("The Order Details is Not Found! Enter Valid Order Id",HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addNewOrder(@Valid @RequestBody OrderDTO dto) {
        OrderDTO order = service.addOrder(dto);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExistingOrder(@Valid @RequestBody OrderDTO dto, @PathVariable int id) {
        OrderDTO uorder = service.updateOrder(dto,id);
        if(uorder != null){
            return new ResponseEntity<>(uorder,HttpStatus.OK);
        }
        else{
            String message = "Unable to Update the Order! Cannot Find the Order in Database";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        String message = service.removeOrder(id);
        if(message != null) {
            return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>("No Data Found",HttpStatus.NOT_FOUND);
        }
    }

}
