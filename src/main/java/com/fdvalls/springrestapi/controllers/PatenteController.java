package com.fdvalls.springrestapi.controllers;

import java.util.List;

import com.fdvalls.springrestapi.clasesExceptions.BadRequestException;
import com.fdvalls.springrestapi.clasesExceptions.NotFoundRequest;
import com.fdvalls.springrestapi.clasesExceptions.ResultOk;
import com.fdvalls.springrestapi.clasesExceptions.RecursosPatentes;
import com.fdvalls.springrestapi.controllers.dto.Request;
import com.fdvalls.springrestapi.controllers.dto.Response;
import com.fdvalls.springrestapi.model.ModeloPatente;
import com.fdvalls.springrestapi.services.PatenteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patente")
public class PatenteController {

    private final PatenteService patenteService;

    public PatenteController(PatenteService patenteService) {
        this.patenteService = patenteService;
    }

    @GetMapping("/all")
    public Response printAllPatentes() {
        List<ModeloPatente> allHelloWorlds = patenteService.getAll();
        String superHello = "";
        for (ModeloPatente patente : allHelloWorlds) {
            superHello += patente.getNroPatente() + " " + patente.getId() + " ";
        }
        return new Response(superHello);
    }

    @PostMapping
    public void savePatente(@RequestBody Request patenteRequest) throws Exception {
        RecursosPatentes recursosPatente = new RecursosPatentes(patenteService);
        // Valido la patente
        if (recursosPatente.validarPatenteVieja(patenteRequest)
                || recursosPatente.validarPatenteNueva(patenteRequest)) {
            // Comprobar si existe
            if (recursosPatente.buscarPatente(patenteRequest) != null) {
                // Devuelvo COD 200
                throw new ResultOk("Id en la base de datos: " + recursosPatente.buscarPatente(patenteRequest));
            } else {
                // Devuelvo COD 400 y lo agrego a mi lista de patentes.
                throw new NotFoundRequest(
                        "No existe esa patente en nuestra base de datos, por lo tanto se agrega a nuestro registro.");
            }
        } else {
            throw new BadRequestException("Formato de patente invalida");
        }
    }
}
