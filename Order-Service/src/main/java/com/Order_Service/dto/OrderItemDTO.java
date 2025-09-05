package com.Order_Service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderItemDTO {
    
    private int id;

    @NotNull(message = "Order Cannot Be Null")
    private int order_id;

    private int quantity = 1;

    private double price;
}
