package com.fdvalls.springrestapi.clasesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class NotFoundRequest extends RuntimeException{

   public static final String DESCRIPCION = "Not found request (404)";

    public NotFoundRequest(String message){
        super(DESCRIPCION+", "+message);
    }

    public NotFoundRequest(){
        super(DESCRIPCION);
    }

}