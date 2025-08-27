package com.Restaurant_Service.service;

import java.util.List;

import com.Restaurant_Service.repository.RestaurantRepo;
import com.Restaurant_Service.dto.RestaurantDTO;
import com.Restaurant_Service.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo repo;

    private RestaurantDTO convertToDTO(Restaurant record) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(record.getId());
        dto.setRestaurant_code(record.getRestaurant_code());
        dto.setRestaurant_name(record.getRestaurant_name());
        dto.setAddress(record.getAddress());
        dto.setPhNumber(record.getPhNumber());
        dto.setRating(record.getRating());
        return dto;
    }

    private Restaurant convertToEntity(RestaurantDTO dto) {
        Restaurant model = new Restaurant();
        model.setId(dto.getId());
        model.setRestaurant_name(dto.getRestaurant_name());
        model.setRestaurant_code(dto.getRestaurant_code());
        model.setAddress(dto.getAddress());
        model.setPhNumber(dto.getPhNumber());
        model.setRating(dto.getRating());
        return model;
    }

    public List<RestaurantDTO> getAllRestaurant() {
        return repo.findAll().stream().map(this::convertToDTO).toList();
    }

    public RestaurantDTO getRestaurantById(int id) {
        Restaurant detail =  repo.findById(id).orElse(null);
        if(detail != null) {
            return convertToDTO(detail);
        }
        else{
            return null;
        }
    }

    public RestaurantDTO saveRestaurant(RestaurantDTO dto) {
        Restaurant entity = repo.save(convertToEntity(dto));
        return convertToDTO(entity);
    }

    public List<RestaurantDTO> saveAllRestaurant(List<RestaurantDTO> dto) {
        List<Restaurant> rest = dto.stream().map(this::convertToEntity).toList();
        List<Restaurant> data = repo.saveAll(rest);
        List<RestaurantDTO> result = data.stream().map(this::convertToDTO).toList();
        return result;
    }

    public RestaurantDTO updateRestaurant(RestaurantDTO dto, int id) {
        Restaurant data = repo.findById(id).get();
        data.setRestaurant_code(dto.getRestaurant_code());
        data.setRestaurant_name(dto.getRestaurant_name());
        data.setAddress(dto.getAddress());
        data.setPhNumber(dto.getPhNumber());
        data.setRating(dto.getRating());
        repo.save(data);
        return convertToDTO(data);
    }

    public String deleteById(int id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "Data is Deleted Successfully!";
        }
        else{
            return "No Data Found!";
        }
    }
}
