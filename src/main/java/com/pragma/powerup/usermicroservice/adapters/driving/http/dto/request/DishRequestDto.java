package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishRequestDto {
    @NotBlank
    private String name;
    @NotNull
    @Min(value = 1, message = "Price must be a positive integer")
    private int price;
    @NotBlank
    private String description;
    @NotBlank
    private String urlImage;
    @NotBlank
    private String category;
    @NotNull
    private Long idRestaurant;
    @NotNull
    private boolean active;
}
