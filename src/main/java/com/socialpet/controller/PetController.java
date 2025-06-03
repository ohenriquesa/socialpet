package com.socialpet.controller;

import com.socialpet.dto.PetDTO;
import com.socialpet.model.Pet;
import com.socialpet.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private  PetService petService;


    @GetMapping
    public List<PetDTO> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pet buscar(@PathVariable Long id) {
        return petService.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Pet criar(@RequestBody Pet pet) {
        return petService.salvar(pet);
    }

    @PutMapping("/{id}")
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet pet) {
        pet.setId(id);
        return petService.salvar(pet);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        petService.excluir(id);
    }

    @PostMapping("/{petid}/vacinas/{vacinaid}")
    public ResponseEntity<?> vacinarPet(@PathVariable Long petid, @PathVariable Long vacinaid) {
        petService.vacinarPet(petid, vacinaid); 
        //TODO: process POST request
        return ResponseEntity.ok().body("Pet vacinado com sucesso!");
    }
    
}