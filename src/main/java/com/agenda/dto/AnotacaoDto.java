package com.agenda.dto;

import com.agenda.entity.Anotacao;
import com.agenda.util.converter.DtoToEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Data
public class AnotacaoDto implements DtoToEntity<Anotacao> {

    @Length(min = 10, max = 30)
    private String titulo;

    @Length(min = 10, max = 50)
    private String texto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @Future
    private LocalDateTime dataEvento;

    @Override
    public Anotacao toEntity() {
        return new ModelMapper().map(this, Anotacao.class);
    }
}
