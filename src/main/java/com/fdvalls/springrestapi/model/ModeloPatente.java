package com.fdvalls.springrestapi.model;

public class ModeloPatente {

    private Long id;
    private String nroPatente;

    public ModeloPatente(Long id, String nroPatente) {
        this.nroPatente = nroPatente;
        this.id = id;
    }

    public ModeloPatente(String nroPatente) {
        this.nroPatente = nroPatente;
    }

    public ModeloPatente() {
    }

    public String getNroPatente() {
        return nroPatente;
    }

    public Long getId() {
        return id;
    }

}
