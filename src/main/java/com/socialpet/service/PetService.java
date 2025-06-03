package com.socialpet.service;

import com.socialpet.dto.PetDTO;
import com.socialpet.model.Pet;
import com.socialpet.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<PetDTO> listarTodos() {
        return petRepository.findAll().stream()
                .map(pet -> new PetDTO(pet.getId(), pet.getNome(), pet.getEspecie()))
                .toList();
    }

    public Optional<Pet> buscarPorId(Long id) {
        return petRepository.findById(id);
    }

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    public void excluir(Long id) {
        petRepository.deleteById(id);
    }
}