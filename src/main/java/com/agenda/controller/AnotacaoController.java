package com.agenda.controller;

import com.agenda.entity.Anotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/anotacao")
public class AnotacaoController {

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> pesquisarPorId(@PathVariable Long id){

        Anotacao anotacao = new Anotacao();
        anotacao.setId(id);
        anotacao.setTitulo("Titulo");
        anotacao.setTexto("Texto");
        anotacao.setDataEvento(LocalDateTime.now());
        anotacao.setDataCadastro(LocalDateTime.now());

        return ResponseEntity.ok(anotacao);
    }

}
