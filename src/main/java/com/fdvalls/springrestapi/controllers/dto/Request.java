package com.fdvalls.springrestapi.controllers.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Request {

    private String nroPatente;
    private Long id;

    @JsonCreator
    public Request(Long id, String nroPatente) {
        this.nroPatente = nroPatente;
        this.id = id;

    }

    public String getNroPatente() {
        return nroPatente;
    }

    public Long getId() {
        return id;
    }

}
