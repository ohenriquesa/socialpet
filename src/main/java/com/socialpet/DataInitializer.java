package com.socialpet;

import com.socialpet.model.*;
import com.socialpet.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final DonoRepository donoRepo;
    private final PetRepository petRepo;
    private final VacinaRepository vacinaRepo;

    public DataInitializer(DonoRepository donoRepo, PetRepository petRepo, VacinaRepository vacinaRepo) {
        this.donoRepo = donoRepo;
        this.petRepo = petRepo;
        this.vacinaRepo = vacinaRepo;
    }

    @PostConstruct
    public void init() {
        Dono dono = new Dono();
        dono.setNome("João Silva");
        dono.setTelefone("(81) 91234-5678");
        dono.setEndereco("Rua das Palmeiras, 123");
        donoRepo.save(dono);

        Vacina v1 = new Vacina();
        v1.setNome("Antirrábica");
        v1.setFabricante("PetPharma");
        vacinaRepo.save(v1);

        Vacina v2 = new Vacina();
        v2.setNome("V10");
        v2.setFabricante("Bayer");

        vacinaRepo.save(v2);

        Pet pet = new Pet();
        pet.setNome("Max");
        pet.setEspecie("Cachorro");
        pet.setRaca("Labrador");
        pet.setIdade(5);
        pet.setRestricaoAlimentar("Não pode comer frango");
        pet.setDono(dono);
        pet.setVacinas(List.of(v1, v2));
        petRepo.save(pet);
    }
}