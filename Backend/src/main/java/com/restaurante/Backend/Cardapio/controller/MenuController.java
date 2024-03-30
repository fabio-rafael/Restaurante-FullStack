package com.restaurante.Backend.Cardapio.controller;

import com.restaurante.Backend.Cardapio.model.Menu;
import com.restaurante.Backend.Cardapio.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveComida(@RequestBody MenuRequestDTO data){
        Menu comidaData = new Menu(data);
        repository.save(comidaData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MenuResponseDTO> getAll(){
        List<MenuResponseDTO> menuList = repository.findAll().stream().map(MenuResponseDTO::new).toList();
        return menuList;
    }
}
