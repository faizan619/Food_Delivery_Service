package com.Order_Service.dto;

import com.Order_Service.config.OrderStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDTO {
    private int id;

    @NotNull(message="Price Cannot be Null")
    private double price;

    private OrderStatus status;

    public OrderDTO(double price, OrderStatus status) {
        this.price = price;
        this.status = status;
    }

    public OrderDTO(double price) {
        this.price = price;
    }
}
