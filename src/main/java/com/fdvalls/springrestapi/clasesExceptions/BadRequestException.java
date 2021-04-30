package com.fdvalls.springrestapi.clasesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class BadRequestException extends Exception{

   public static final String DESCRIPCION = "Bad Request Exception (400)";

    public BadRequestException(String message){
        super(DESCRIPCION+", "+message);
    }

}