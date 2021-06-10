package com.agenda.dto;

import com.agenda.entity.Anotacao;
import com.agenda.util.converter.DtoToEntity;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
public class AnotacaoDataEventoDto implements DtoToEntity<Anotacao> {

    private LocalDateTime dataEvento;

    @Override
    public Anotacao toEntity() {
        return new ModelMapper().map(this, Anotacao.class);
    }
}