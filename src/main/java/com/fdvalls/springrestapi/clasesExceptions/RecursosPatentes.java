package com.fdvalls.springrestapi.clasesExceptions;

import java.util.List;

import com.fdvalls.springrestapi.controllers.dto.Request;
import com.fdvalls.springrestapi.model.ModeloPatente;
import com.fdvalls.springrestapi.services.PatenteService;

public class RecursosPatentes {

    private final PatenteService helloWorldService;

    public RecursosPatentes(PatenteService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public boolean validarPatenteVieja(Request helloWorldRequest) {
        String cadena = helloWorldRequest.getNroPatente().toUpperCase();
        boolean esValido = false;
        int contNumero = 0;
        int contLetra = 0;
        if (cadena.length() == 6) {
            for (int i = 0; i < cadena.length() / 2; i++) {
                char c = cadena.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    contLetra++;
                }
            }
            if (contLetra == 3) {
                for (int i = (cadena.length() / 2); i < cadena.length(); i++) {
                    char c = cadena.charAt(i);
                    if (!(c >= 'A' && c <= 'Z')) {
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

    public boolean validarPatenteNueva(Request helloWorldRequest) {
        String cadena = helloWorldRequest.getNroPatente().toUpperCase();
        boolean esValido = false;
        int contNumero = 0;
        int contLetra = 0;
        if (cadena.length() == 7) {
            for (int i = 0; i <= 1; i++) {
                char c = cadena.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    contLetra++;
                }
            }
            for (int i = 2; i <= 4; i++) {
                char c = cadena.charAt(i);
                if (!(c >= 'A' && c <= 'Z')) {
                    contNumero++;
                }
            }

            for (int i = 5; i <= 6; i++) {
                char c = cadena.charAt(i);
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

    public Long buscarPatente(Request helloWorldRequest) {
        boolean seEncontro = false;
        Long myId = null;
        List<ModeloPatente> allHelloWorlds = helloWorldService.getAll();
        int i = 0;
        while (i < allHelloWorlds.size() && !seEncontro) {
            if (allHelloWorlds.get(i).getNroPatente().toUpperCase()
                    .equals(helloWorldRequest.getNroPatente().toUpperCase())) {
                seEncontro = true;
                myId = allHelloWorlds.get(i).getId();
            } else {
                i++;
            }
        }
        if (!seEncontro) {
            ModeloPatente helloWorld = new ModeloPatente(helloWorldRequest.getNroPatente());
            helloWorldService.save(helloWorld);
        }
        return myId;
    }
}