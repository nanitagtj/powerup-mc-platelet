package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.usermicroservice.domain.feigndatasource.IUserClientPort;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserClientPort userClientPort;

    public RestaurantUseCase(IRestaurantPersistencePort userPersistencePort, IUserClientPort userClientPort) {
        this.restaurantPersistencePort = userPersistencePort;
        this.userClientPort = userClientPort;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        boolean user = userClientPort.getUser(restaurant.getIdOwner());
        restaurantPersistencePort.createRestaurant(restaurant);
    }

}
