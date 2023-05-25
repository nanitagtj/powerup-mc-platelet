package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IDishRepository extends JpaRepository<DishEntity, Long> {
    Optional<DishEntity> findById(Long id);

    boolean existsById(Long id);

    boolean existsByNameAndRestaurantId(String name, Long idRestaurant);
}
