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

    private OrderItems changeToEntity(OrderItemDTO dto) {
        OrderItems entity = new OrderItems();
        entity.setOrder_id(dto.getOrder_id());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public List<OrderItemDTO> viewAllItems() {
        return repo.findAll().stream().map(this::changeToDTO).toList();
    }

    public OrderItemDTO addOrdersItems(OrderItemDTO dto) {
        OrderItems order = repo.save(changeToEntity(dto));
        return changeToDTO(order);
    }

    public OrderItemDTO updateItem(OrderItemDTO dto, int id) {
        if (repo.existsById(id)) {
            OrderItems order = repo.findById(id).get();
            order.setQuantity(dto.getQuantity());
            order.setPrice(dto.getPrice());
            OrderItems data = repo.save(order);
            return changeToDTO(data);
        }
        return null;
    }

    public String deleteItem(int id) {    
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Item is Deleted Successfully!";
        }
        return "Unable to Find the Data in our record!";
    }
}
