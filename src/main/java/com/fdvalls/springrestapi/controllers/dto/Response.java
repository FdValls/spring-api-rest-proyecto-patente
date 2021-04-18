package com.fdvalls.springrestapi.controllers.dto;

public class Response {

    private String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
