package com.agenda.controller;

import com.agenda.entity.Anotacao;
import com.agenda.service.AnotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Anotacao anotacao = anotacaoService.pesquisarPorId(id);
        return ResponseEntity.ok(anotacao);
    }

}
