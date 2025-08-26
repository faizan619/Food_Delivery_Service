package com.Restaurant_Service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RestaurantDTO {
    
    private int id;

    @NotBlank(message="Restaurant Code is Mandatory")
    private String restaurant_code;
    
    @NotBlank(message="Restaurant Name is Mandatory")
    private String restaurant_name;
    
    private String address;
    
    private String phNumber;

    private int rating = 5;

    public RestaurantDTO(String restaurant_code, String restaurant_name, String address, String phNumber,int rating) {
        this.restaurant_code = restaurant_code;
        this.restaurant_name = restaurant_name;
        this.address = address;
        this.phNumber = phNumber;
        this.rating = rating;
    }
    public RestaurantDTO(String restaurant_code, String restaurant_name, String address,int rating) {
        this.restaurant_code = restaurant_code;
        this.restaurant_name = restaurant_name;
        this.address = address;
        this.rating = rating;
    }
    public RestaurantDTO(String restaurant_code, String restaurant_name,int rating) {
        this.restaurant_code = restaurant_code;
        this.restaurant_name = restaurant_name;
        this.rating = rating;
    }

}
