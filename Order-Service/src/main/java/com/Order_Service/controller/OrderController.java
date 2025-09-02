package com.Order_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Order_Service.config.OrderStatus;
import com.Order_Service.dto.OrderDTO;
import com.Order_Service.service.OrderService;

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
    public ResponseEntity<?> getOrderDetails(int id) {
        OrderDTO order = service.getOrderDetails(id);
        if(order != null) {
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("The Order Details is Not Found! Enter Valid Order Id",HttpStatus.OK);
        }
    }
}
