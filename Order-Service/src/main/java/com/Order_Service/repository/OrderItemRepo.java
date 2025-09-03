package com.Order_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Order_Service.model.OrderItems;

public interface OrderItemRepo extends JpaRepository<OrderItems, Integer> {
    
}
