package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestaurantResponseDto {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String nit;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    private String urlLogo;
    @NotBlank
    private Long idOwner;
}
