package com.agenda.service;

import com.agenda.entity.Anotacao;

public interface AnotacaoService {

    Anotacao salvar(Anotacao anotacao);

    Anotacao pesquisarPorId(Long id);

    Anotacao atualizar(Long id, Anotacao anotacao);
}
