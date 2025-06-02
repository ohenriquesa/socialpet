package com.socialpet.controller;

import com.socialpet.model.Vacina;
import com.socialpet.service.VacinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    private final VacinaService vacinaService;
    public VacinaController(VacinaService vacinaService) { this.vacinaService = vacinaService; }

    @GetMapping public List<Vacina> listarTodos() { return vacinaService.listarTodos(); }
    @GetMapping("/{id}") public Vacina buscar(@PathVariable Long id) { return vacinaService.buscarPorId(id).orElseThrow(); }
    @PostMapping public Vacina criar(@RequestBody Vacina vacina) { return vacinaService.salvar(vacina); }
    @PutMapping("/{id}") public Vacina atualizar(@PathVariable Long id, @RequestBody Vacina vacina) { vacina.setId(id); return vacinaService.salvar(vacina); }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { vacinaService.excluir(id); }
}
