package com.socialpet.controller;

import com.socialpet.dto.PetDTO;
import com.socialpet.model.Pet;
import com.socialpet.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}