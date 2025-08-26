package com.Restaurant_Service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="restaurants", schema="practise_food_restaurants")
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

    @Column(nullable=false,unique=true)
    private String restaurant_code;

    @Column(nullable=false)
    private String restaurant_name;

    @Column(nullable=true)
    private String address;
    
    @Column(nullable=true)
    private String phNumber;

    private int rating;
}
