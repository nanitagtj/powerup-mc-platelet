package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl.IDishHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.usecase.DishUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/platelet")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class DishController {
    private final IDishHandler dishHandler;
    private final DishUseCase dishUseCase;

    @Operation(summary = "Add a new dish",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Dish created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Dish already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/dish")
    public ResponseEntity<Map<String, String>> createDish(@Valid @RequestBody DishRequestDto dishRequestDto) {
        dishHandler.createDish(dishRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISH_CREATED_MESSAGE));
    }
    @Operation(summary = "Update a new dish",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Dish created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Dish already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("/dishes/{id}")
    public ResponseEntity<?> updateDish(@PathVariable("id") Long id, @RequestBody DishUpdateRequestDto dishUpdateRequestDto) {
        dishUseCase.updateDish(id, dishUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.DISH_UPDATED_MESSAGE));
    }
}
