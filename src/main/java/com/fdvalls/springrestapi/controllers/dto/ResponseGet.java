package com.fdvalls.springrestapi.controllers.dto;

public class ResponseGet {

    private final Long id;

    public ResponseGet(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
