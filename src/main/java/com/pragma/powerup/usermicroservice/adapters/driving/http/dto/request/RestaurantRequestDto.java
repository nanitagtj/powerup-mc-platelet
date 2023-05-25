package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestaurantRequestDto {

    @NotBlank()
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\d+", message = "El Nit must be numeric")
    private String nit;

    @NotBlank(message = "Address must not be null")
    private String address;

    @NotBlank(message = "Phone must not be null")
    @Pattern(regexp = "\\+\\d{1,12}", message = "Phone must be numeric and must be 12 digits including "+" ")
    private String phone;

    @NotBlank(message = "La URL del logo es obligatoria")
    private String urlLogo;

    @NotNull(message = "El ID del propietario es obligatorio")
    private Long idOwner;
}
