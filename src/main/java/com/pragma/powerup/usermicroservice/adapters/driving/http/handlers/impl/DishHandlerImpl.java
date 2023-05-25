package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IDishResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler{
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;

    @Override
    public void createDish(DishRequestDto dishRequestDto) {
        Dish dish = dishRequestMapper.toDish(dishRequestDto);
        dishServicePort.createDish(dish);
    }

    @Override
    public Page<DishResponseDto> getAllDishes(Pageable pageable) {
        Page<Dish> dishes = dishServicePort.getAllDishes(pageable);
        return dishes.map(dishResponseMapper::dishToDishResponseDto);
    }
}
