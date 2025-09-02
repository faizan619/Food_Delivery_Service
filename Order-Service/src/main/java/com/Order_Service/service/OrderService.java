package com.Order_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order_Service.config.OrderStatus;
import com.Order_Service.dto.OrderDTO;
import com.Order_Service.model.Orders;
import com.Order_Service.repository.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepo repo;

    private OrderDTO convertToDTO(Orders entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus() != null ? entity.getStatus() : OrderStatus.PENDING);   

        return dto;
    }

    public Orders convertToEntity(OrderDTO dto) {
        Orders entity = new Orders();
        entity.setId(dto.getId());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());

        return entity;
    }

    public List<OrderDTO> getAllOrder() {
        return repo.findAll().stream().map(this::convertToDTO).toList();
    }

    public List<OrderDTO> getAllOrdersByStatus(OrderStatus status) {
        return repo.findByStatus(status).stream().map(this::convertToDTO).toList();
    }

    public OrderDTO getOrderDetails(int id) {
        Orders order = repo.findById(id).orElse(null);
        if(order != null) {
            OrderDTO dto = convertToDTO(order);
            return dto;
        }
        return null;
    }
}
