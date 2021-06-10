package com.agenda.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
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

    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersit(){
        setDataCadastro(LocalDateTime.now());
        log.info("Data de cadastro: {}", getDataCadastro());
    }

}
