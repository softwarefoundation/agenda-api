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
        Anotacao anotacao = new Anotacao(id, "Titulo", "Texto", LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.ok(anotacao);
    }

}
