package com.pragma.powerup.usermicroservice.domain.validations;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DishAlreadyExistsException;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;

public class Validations {
    private final IDishPersistencePort dishPersistencePort;

    public Validations(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    public void validateDish(Dish dish) {
        validateUniqueDishName(dish);
    }

    private void validateUniqueDishName(Dish dish) {
        String name = dish.getName();
        Long idRestaurant = dish.getRestaurant().getId();

        if (dishPersistencePort.existsDishByNameAndRestaurant(name, idRestaurant)) {
            throw new DishAlreadyExistsException();
        }
    }
}
