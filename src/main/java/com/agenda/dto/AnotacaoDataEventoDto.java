package com.agenda.dto;

import com.agenda.entity.Anotacao;
import com.agenda.util.converter.DtoToEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Data
public class AnotacaoDataEventoDto implements DtoToEntity<Anotacao> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @Future(message = "A data do evento deve ser uma posterior a data atual")
    private LocalDateTime dataEvento;

    @Override
    public Anotacao toEntity() {
        return new ModelMapper().map(this, Anotacao.class);
    }
}
