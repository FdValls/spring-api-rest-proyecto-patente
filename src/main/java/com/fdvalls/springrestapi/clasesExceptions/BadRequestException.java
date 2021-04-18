package com.fdvalls.springrestapi.clasesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class BadRequestException extends RuntimeException{

   public static final String DESCRPCION = "Bad Request Exception (400)";

    public BadRequestException(String message){
        super(DESCRPCION+", "+message);
    }

}