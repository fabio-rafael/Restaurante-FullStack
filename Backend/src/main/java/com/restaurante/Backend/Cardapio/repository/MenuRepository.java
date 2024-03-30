package com.restaurante.Backend.Cardapio.repository;

import com.restaurante.Backend.Cardapio.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
