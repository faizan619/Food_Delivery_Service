package com.Order_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order_Service.dto.OrderItemDTO;
import com.Order_Service.model.OrderItems;
import com.Order_Service.repository.OrderItemRepo;

@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepo repo;

    private OrderItemDTO changeToDTO(OrderItems entity) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setOrder_id(entity.getOrder_id());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public List<OrderItemDTO> viewAllItems() {
        return repo.findAll().stream().map(this::changeToDTO).toList();
    }
}
