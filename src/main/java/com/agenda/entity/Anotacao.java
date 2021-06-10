package com.agenda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Anotacao {

    private Long id;
    private String titulo;
    private String texto;
    private LocalDateTime dataEvento;
    private LocalDateTime dataCadastro;

}
