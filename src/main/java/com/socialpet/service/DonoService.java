package com.socialpet.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.socialpet.model.Dono;
import com.socialpet.repository.DonoRepository;

@Service
public class DonoService {
    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository) {
        this.donoRepository = donoRepository;
    }

    public List<Dono> listarTodos() {
        return donoRepository.findAll();
    }

    public Optional<Dono> buscarPorId(Long id) {
        return donoRepository.findById(id);
    }

    public Dono salvar(Dono dono) {
        return donoRepository.save(dono);
    }

    public void excluir(Long id) {
        donoRepository.deleteById(id);
    }
}