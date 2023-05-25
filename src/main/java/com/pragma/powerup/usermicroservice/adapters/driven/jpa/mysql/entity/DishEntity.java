package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dishes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "price")
    private int price;
    @NotBlank
    @Column(name = "description")
    private String description;
    @NotBlank
    @Column(name = "url_image")
    private String urlImage;
    @NotBlank
    @Column(name = "category")
    private String category;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_restaurant")
    private RestaurantEntity restaurant;
    @NotNull
    @Column(name = "active")
    private boolean active;
}
