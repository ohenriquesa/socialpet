package com.socialpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.socialpet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {}
