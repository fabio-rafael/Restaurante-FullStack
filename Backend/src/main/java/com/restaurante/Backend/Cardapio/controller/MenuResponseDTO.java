package com.restaurante.Backend.Cardapio.controller;

import com.restaurante.Backend.Cardapio.model.Menu;

import java.math.BigDecimal;

public record MenuResponseDTO(Long id, String title, BigDecimal price, String image) {
    public MenuResponseDTO(Menu comida){
        this(comida.getId(), comida.getTitle(), comida.getPrice(), comida.getImage());
    }
}
