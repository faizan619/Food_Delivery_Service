package com.Order_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Order_Service.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
    
}
