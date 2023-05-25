package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp ="^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d\\s]+$")
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d+")
    private String nit;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "\\+\\d{1,12}")
    private String phone;
    @NotBlank
    private String urlLogo;
    @NotNull
    private Long idOwner;
}
