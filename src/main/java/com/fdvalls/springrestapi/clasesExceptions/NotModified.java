package com.fdvalls.springrestapi.clasesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)

public class NotModified extends Exception{

    public static final String DESCRIPCION = "Not Modified (304), sistema de entrada incorrecto.";

    public NotModified(String message){
        super(DESCRIPCION+", "+message);
    }
    
}
