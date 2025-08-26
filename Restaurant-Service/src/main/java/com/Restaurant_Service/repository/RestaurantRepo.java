package com.Restaurant_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Restaurant_Service.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
    
}
