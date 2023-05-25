package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DishResponseDto {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private int price;
    @NotBlank
    private String description;
    @NotBlank
    private String urlImage;
    @NotBlank
    private String category;
    @NotNull
    private Long idRestaurant;
    @NotBlank
    private boolean active;

}
