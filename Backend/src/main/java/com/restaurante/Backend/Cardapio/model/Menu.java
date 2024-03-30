package com.restaurante.Backend.Cardapio.model;

import com.restaurante.Backend.Cardapio.controller.MenuRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "menu")
@Entity(name = "menu")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    public Menu(MenuRequestDTO data) {
        this.title = data.title();
        this.price = data.price();
        this.image = data.image();
    }
}
