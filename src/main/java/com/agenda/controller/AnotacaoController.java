package com.agenda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/anotacao")
public class AnotacaoController {

    @GetMapping
    public ResponseEntity<?> getAnotacao(){
        return ResponseEntity.ok("Anotação GET");
    }

    @PostMapping
    public ResponseEntity<?> getAnotacao2(){
        return ResponseEntity.ok("Anotação POST");
    }

}
