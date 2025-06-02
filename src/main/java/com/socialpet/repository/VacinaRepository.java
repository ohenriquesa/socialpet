package com.socialpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.socialpet.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {}