package com.socialpet.service;

import com.socialpet.dto.PetDTO;
import com.socialpet.model.Pet;
import com.socialpet.model.Vacina;
import com.socialpet.repository.PetRepository;
import com.socialpet.repository.VacinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VacinaRepository vacinaRepository;

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

    public String vacinarPet(Long petId, Long vacinaId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        Vacina vacina = vacinaRepository.findById(vacinaId)
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

        pet.getVacinas().add(vacina);
        petRepository.save(pet);
        return "Pet vacinado com sucesso!";
    }
}