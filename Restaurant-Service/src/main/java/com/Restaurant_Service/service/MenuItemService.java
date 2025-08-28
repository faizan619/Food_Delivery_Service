package com.Restaurant_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant_Service.repository.MenuItemRepo;
import com.Restaurant_Service.repository.RestaurantRepo;

import com.Restaurant_Service.dto.MenuItemDTO;
import com.Restaurant_Service.model.MenuItems;
import com.Restaurant_Service.model.Restaurant;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepo repo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    private MenuItemDTO changeToDTO(MenuItems item) {
        MenuItemDTO dto = new MenuItemDTO();
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setAvailablity(item.getAvailablity());

        // ✅ Set restaurantId from the associated Restaurant
        if (item.getRestaurant() != null) {
            dto.setRestaurantId(item.getRestaurant().getId());
        }

        return dto;
    }

    private MenuItems changeToEntity(MenuItemDTO dto) {
        MenuItems item = new MenuItems();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setAvailablity(dto.getAvailablity());

        Restaurant restaurant = restaurantRepo.findById(dto.getRestaurantId()).orElse(null);
        System.out.println("============[conversion]==================[ " + dto.getRestaurantId() + " ]");
        item.setRestaurant(restaurant);
        return item;
    }

    public List<MenuItemDTO> getAllMenu() {
        return repo.findAll().stream().map(this::changeToDTO).toList();
    }

    public MenuItemDTO addNewMenuItem(MenuItemDTO dto) {
        System.out.println("============[service]==================[ " + dto.getRestaurantId() + " ]");
        MenuItems result = repo.save(changeToEntity(dto));
        return changeToDTO(result);
    }

    public MenuItemDTO updateMenuItem(MenuItemDTO dto, int id) {
        MenuItems item = repo.findById(id).orElse(null);
        if (item != null) {
            item.setName(dto.getName());
            item.setPrice(dto.getPrice());
            item.setAvailablity(dto.getAvailablity());
            MenuItems result = repo.save(item);
            return changeToDTO(result);
        } else {
            throw new RuntimeException("Menu item with ID " + id + " not found");
        }
    }

    public String deleteMenuItem(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Data is Deleted Successfully";
        }
        else{
            return "Data is Not Found";
        }
    }
}
