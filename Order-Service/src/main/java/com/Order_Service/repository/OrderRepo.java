package com.Order_Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Order_Service.config.OrderStatus;
import com.Order_Service.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

    // List<Orders> findByStatus(OrderStatus status);
    @Query("SELECT o FROM Orders o WHERE o.status = :status")
    List<Orders> findByStatus(@Param("status") OrderStatus status);
    
}
