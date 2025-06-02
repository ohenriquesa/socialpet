package com.socialpet.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.socialpet.model.Vacina;
import com.socialpet.repository.VacinaRepository;

@Service
public class VacinaService {
    private final VacinaRepository vacinaRepository;
    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }
    public List<Vacina> listarTodos() { return vacinaRepository.findAll(); }
    public Optional<Vacina> buscarPorId(Long id) { return vacinaRepository.findById(id); }
    public Vacina salvar(Vacina vacina) { return vacinaRepository.save(vacina); }
    public void excluir(Long id) { vacinaRepository.deleteById(id); }
    
}