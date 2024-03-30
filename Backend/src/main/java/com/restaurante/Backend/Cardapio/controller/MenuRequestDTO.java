package com.restaurante.Backend.Cardapio.controller;

import java.math.BigDecimal;

public record MenuRequestDTO(String title, BigDecimal price, String image) {
}
