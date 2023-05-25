package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    @Mapping(target = "restaurant", source = "restaurant")
    DishEntity toEntity(Dish dish);

    List<Dish> toDishList(List<DishEntity> dishEntityList);

    default Page<Dish> toDishPage(Page<DishEntity> dishEntityPage) {
        List<Dish> dishList = toDishList(dishEntityPage.getContent());
        return new PageImpl<>(dishList, dishEntityPage.getPageable(), dishEntityPage.getTotalElements());
    }

    Dish toDish(DishEntity dishEntity);
}
