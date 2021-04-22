package com.fdvalls.springrestapi.clasesExceptions;

import com.fdvalls.springrestapi.services.PatenteService;

public class ValidarPatente {

    private final PatenteService patenteService;

    public ValidarPatente(PatenteService patenteService) {
        this.patenteService = patenteService;
    }

    public boolean validarPatenteVieja(String cadena) {
        String miPatente = cadena.toUpperCase();
        boolean esValido = false;
        int contNumero = 0;
        int contLetra = 0;
        if (miPatente.length() == 6) {
            for (int i = 0; i < miPatente.length() / 2; i++) {
                char c = miPatente.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    contLetra++;
                }
            }
            if (contLetra == 3) {
                for (int i = (miPatente.length() / 2); i < miPatente.length(); i++) {
                    char c = miPatente.charAt(i);
                    if (c >= '0' && c <= '9') {
                        contNumero++;
                    }
                }
            }
            if (contNumero == 3 && contLetra == 3) {
                esValido = true;
            }
        }
        return esValido;
    }

    public boolean validarPatenteNueva(String cadena) {
        String miPatente = cadena.toUpperCase();
        boolean esValido = false;
        int contNumero = 0;
        int contLetra = 0;
        if (miPatente.length() == 7) {
            for (int i = 0; i <= 1; i++) {
                char c = miPatente.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    contLetra++;
                }
            }
            for (int i = 2; i <= 4; i++) {
                char c = miPatente.charAt(i);
                if (c >= '0' && c <= '9') {
                    contNumero++;
                }
            }

            for (int i = 5; i <= 6; i++) {
                char c = miPatente.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    contLetra++;
                }
            }

            if (contNumero == 3 && contLetra == 4) {
                esValido = true;
            }
        }
        return esValido;
    }

}