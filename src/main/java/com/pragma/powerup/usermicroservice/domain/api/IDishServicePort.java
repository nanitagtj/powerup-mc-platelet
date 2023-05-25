package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishServicePort {
    void createDish(Dish dish);

    Page<Dish> getAllDishes(Pageable pageable);

    void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto);
}
