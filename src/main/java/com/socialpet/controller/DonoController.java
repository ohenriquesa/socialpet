package com.socialpet.controller;

import com.socialpet.model.Dono;
import com.socialpet.service.DonoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donos")
public class DonoController {
    private final DonoService donoService;

    public DonoController(DonoService donoService) {
        this.donoService = donoService;
    }

    @GetMapping
    public List<Dono> listarTodos() {
        return donoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Dono buscar(@PathVariable Long id) {
        return donoService.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Dono criar(@RequestBody Dono dono) {
        return donoService.salvar(dono);
    }

    @PutMapping("/{id}")
    public Dono atualizar(@PathVariable Long id, @RequestBody Dono dono) {
        dono.setId(id);
        return donoService.salvar(dono);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        donoService.excluir(id);
    }
}
