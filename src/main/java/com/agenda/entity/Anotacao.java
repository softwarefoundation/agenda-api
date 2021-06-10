package com.agenda.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@DynamicUpdate
@Entity
@Table(name = "tb01_anotacao")
public class Anotacao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 30)
    private String titulo;

    @Column(name = "texto", length = 100)
    private String texto;
    
    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

}
