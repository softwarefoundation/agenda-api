package com.agenda.controller;

import com.agenda.entity.Anotacao;
import com.agenda.exceptions.RegistroNaoLocalizadoException;
import com.agenda.service.AnotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/anotacao")
public class AnotacaoController {

    private AnotacaoService anotacaoService;

    @Autowired
    public AnotacaoController(AnotacaoService anotacaoService) {
        this.anotacaoService = anotacaoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> pesquisarPorId(@PathVariable Long id) {
        try {
            Anotacao anotacao = anotacaoService.pesquisarPorId(id);
            return ResponseEntity.ok(anotacao);
        } catch (RegistroNaoLocalizadoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Anotacao anotacao) {
        Anotacao anotacaoSalva = anotacaoService.salvar(anotacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(anotacaoSalva);
    }

}
