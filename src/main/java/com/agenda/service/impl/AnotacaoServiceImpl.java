package com.agenda.service.impl;

import com.agenda.entity.Anotacao;
import com.agenda.service.AnotacaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnotacaoServiceImpl implements AnotacaoService {

    @Override
    public Anotacao pesquisarPorId(Long id) {

        Anotacao anotacao = new Anotacao();
        anotacao.setId(id);
        anotacao.setTitulo("Titulo");
        anotacao.setTexto("Texto");
        anotacao.setDataEvento(LocalDateTime.now());
        anotacao.setDataCadastro(LocalDateTime.now());

        return anotacao;
    }
}
