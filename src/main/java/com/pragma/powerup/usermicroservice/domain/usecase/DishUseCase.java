package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.usermicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.Validations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final Validations dishValidator;

    public DishUseCase(IDishPersistencePort dishPersistencePort, Validations dishValidator) {
        this.dishPersistencePort = dishPersistencePort;
        this.dishValidator = dishValidator;
    }

    @Override
    public void createDish(Dish dish) {
        dishValidator.validateDish(dish);
        dish.setActive(true);
        dishPersistencePort.createDish(dish);
    }

    @Override
    public Page<Dish> getAllDishes(Pageable pageable){
        Page<Dish> dishesList =  dishPersistencePort.getAllDishes(pageable);
        return dishesList;
    }

    @Override
    public void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto) {
        Dish dish = dishPersistencePort.getDishById(id);

        dish.setDescription(dishUpdateRequestDto.getDescription());
        dish.setPrice(dishUpdateRequestDto.getPrice());

        dishPersistencePort.updateDish(dish);
    }
}
