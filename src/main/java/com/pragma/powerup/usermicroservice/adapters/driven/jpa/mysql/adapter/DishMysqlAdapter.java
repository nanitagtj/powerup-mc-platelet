package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DishAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RequiredArgsConstructor
public class DishMysqlAdapter implements IDishPersistencePort{
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void createDish(Dish dish) {
        if (dish.getId() != null && dishRepository.findById(dish.getId()).isPresent()) {
            throw new DishAlreadyExistsException();
        }
        DishEntity dishEntity = dishEntityMapper.toEntity(dish);
        dishRepository.save(dishEntity);
    }

    @Override
    public boolean existsDishByNameAndRestaurant(String name, Long idRestaurant) {
        return dishRepository.existsByNameAndRestaurantId(name, idRestaurant);
    }

    @Override
    public Page<Dish> getAllDishes(Pageable pageable) {
        Page<DishEntity> dishEntityPage = dishRepository.findAll(pageable);
        if (dishEntityPage.isEmpty()) {
            throw new NoDataFoundException();
        }
        return dishEntityMapper.toDishPage(dishEntityPage);
    }

    @Override
    public Dish getDishById(Long id) {
        DishEntity dishEntity = dishRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException());
        return dishEntityMapper.toDish(dishEntity);
    }

    @Override
    public void updateDish(Dish dish) {
        DishEntity dishEntity = dishRepository.findById(dish.getId())
                .orElseThrow(() -> new NoDataFoundException());

        dishEntity.setDescription(dish.getDescription());
        dishEntity.setPrice(dish.getPrice());

        dishRepository.save(dishEntity);
    }
}
