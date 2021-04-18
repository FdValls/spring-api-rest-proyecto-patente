package com.fdvalls.springrestapi.clasesManejoExcepciones;

import javax.servlet.http.HttpServletRequest;

import com.fdvalls.springrestapi.clasesExceptions.BadRequestException;
import com.fdvalls.springrestapi.clasesExceptions.NotFoundRequest;
import com.fdvalls.springrestapi.clasesExceptions.ResultOk;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ManejadorExcepciones {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ResultOk.class})
    @ResponseBody
    public ErrorMessage resultOk(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundRequest.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

}
