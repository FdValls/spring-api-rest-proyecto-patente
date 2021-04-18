package com.fdvalls.springrestapi.clasesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)

public class ResultOk extends RuntimeException {

    public static final String DESCRPCION = "Result OK (200)";

    public ResultOk(String message) {
        super(DESCRPCION + ", " + message);
    }

}
