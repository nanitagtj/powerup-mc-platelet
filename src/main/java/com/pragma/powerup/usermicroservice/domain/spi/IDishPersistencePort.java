package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishPersistencePort {
    void createDish(Dish dish);

    boolean existsDishByNameAndRestaurant(String name, Long idRestaurant);

    Page<Dish> getAllDishes(Pageable pageable);

    Dish getDishById(Long id);

    void updateDish(Dish dish);
}
