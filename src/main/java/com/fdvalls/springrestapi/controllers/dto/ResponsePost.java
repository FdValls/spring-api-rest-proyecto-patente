package com.fdvalls.springrestapi.controllers.dto;

public class ResponsePost {

    private final Number id;

    public ResponsePost(Number id) {
        this.id = id;
    }

    public Number getId() {
        return id;
    }


}
