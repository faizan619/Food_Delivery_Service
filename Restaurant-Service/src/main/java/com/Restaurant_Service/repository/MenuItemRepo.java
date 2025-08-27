package com.Restaurant_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant_Service.model.MenuItems;

public interface MenuItemRepo extends JpaRepository<MenuItems,Integer> {
    
}
