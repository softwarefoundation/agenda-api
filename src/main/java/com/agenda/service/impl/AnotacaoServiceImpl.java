package com.agenda.service.impl;

import com.agenda.entity.Anotacao;
import com.agenda.exceptions.RegistroNaoLocalizadoException;
import com.agenda.repository.AnotacaoRepository;
import com.agenda.service.AnotacaoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
       return anotacaoRepository.findById(id).orElseThrow(()-> new RegistroNaoLocalizadoException(id));
    }

    @Override
    public Anotacao atualizar(Long id, Anotacao anotacao){
        Anotacao anotacaoRetorno = pesquisarPorId(id);
        BeanUtils.copyProperties(anotacao, anotacaoRetorno,"id","dataCadastro");
        return anotacaoRepository.save(anotacaoRetorno);
    }

    @Override
    public void deletar(Long id) {
        Anotacao anotacao = pesquisarPorId(id);
        anotacaoRepository.delete(anotacao);
    }

    @Override
    public Anotacao atualizarDataEvento(Long id, Anotacao anotacao) {
        Anotacao anotacaoRetorno = pesquisarPorId(id);
        anotacaoRetorno.setDataEvento(anotacao.getDataEvento());
        return anotacaoRepository.save(anotacaoRetorno);
    }
}
