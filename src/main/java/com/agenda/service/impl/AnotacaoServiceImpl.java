package com.agenda.service.impl;

import com.agenda.entity.Anotacao;
import com.agenda.repository.AnotacaoRepository;
import com.agenda.service.AnotacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class AnotacaoServiceImpl implements AnotacaoService {

    private AnotacaoRepository anotacaoRepository;

    @Autowired
    public AnotacaoServiceImpl(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    @Override
    public Anotacao salvar(Anotacao anotacao) {
        anotacao.setDataCadastro(LocalDateTime.now());
        return anotacaoRepository.save(anotacao);
    }

    @Override
    public Anotacao pesquisarPorId(Long id) {

        Anotacao anotacao = new Anotacao();
        anotacao.setId(id);
        anotacao.setTitulo("Titulo");
        anotacao.setTexto("Texto");
        anotacao.setDataEvento(LocalDateTime.now());
        anotacao.setDataCadastro(LocalDateTime.now());

        log.info("Data evento: ".concat(anotacao.getDataEvento().toString()));

        return anotacaoRepository.save(anotacao);
    }
}
