package com.agenda.entity;

import java.time.LocalDateTime;

public class Anotacao {

    private Long id;
    private String titulo;
    private String texto;
    private LocalDateTime dataEvento;
    private LocalDateTime dataCadastro;

    public Anotacao(Long id, String titulo, String texto, LocalDateTime dataEvento, LocalDateTime dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.dataEvento = dataEvento;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
