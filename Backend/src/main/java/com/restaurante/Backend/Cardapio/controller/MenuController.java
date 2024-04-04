package com.restaurante.Backend.Cardapio.controller;

import com.restaurante.Backend.Cardapio.model.Menu;
import com.restaurante.Backend.Cardapio.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteComida(@PathVariable Long id){
        repository.deleteById(id);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateComida(@PathVariable Long id, @RequestBody MenuRequestDTO data) {
        Optional<Menu> optionalMenu = repository.findById(id);

        if (optionalMenu.isPresent()) {
            Menu comidaData = optionalMenu.get();

            // Verifica se o título foi alterado e se já existe um item com o novo título
            if (!comidaData.getTitle().equals(data.title())) {
                Optional<Menu> existingMenuWithTitle = repository.findByTitle(data.title());
                if (existingMenuWithTitle.isPresent()) {
                    return ResponseEntity.badRequest().body("Já existe um item de menu com este título.");
                }
            }

            comidaData.setTitle(data.title());
            comidaData.setPrice(data.price());
            comidaData.setImage(data.image());

            repository.save(comidaData);
            return ResponseEntity.ok("Item do menu atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
