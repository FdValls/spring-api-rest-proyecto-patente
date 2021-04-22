package com.fdvalls.springrestapi.clasesManejoExcepciones;

public class ErrorMessage {

    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;

    }

    public ErrorMessage(Long id) {
        this.message = "Id = " + String.valueOf(id);
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "exception='" + exception + '\'' + ", message='" + '\'' + ", path='" + path + '\''
                + '}';
    }

    

}
