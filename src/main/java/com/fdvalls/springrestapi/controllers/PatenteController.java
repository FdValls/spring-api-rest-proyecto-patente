package com.fdvalls.springrestapi.controllers;

import com.fdvalls.springrestapi.clasesExceptions.BadRequestException;
import com.fdvalls.springrestapi.clasesExceptions.NotFoundRequest;
import com.fdvalls.springrestapi.clasesExceptions.NotModified;
import com.fdvalls.springrestapi.clasesExceptions.ValidarPatente;
import com.fdvalls.springrestapi.controllers.dto.Request;
import com.fdvalls.springrestapi.controllers.dto.Response;
import com.fdvalls.springrestapi.model.ModeloPatente;
import com.fdvalls.springrestapi.services.PatenteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patente")
public class PatenteController {

    private final PatenteService patenteService;

    public PatenteController(PatenteService patenteService) {
        this.patenteService = patenteService;
    }

    @GetMapping("/nroDePatente")
    public Response printPatente(@RequestParam("patente") String patente) throws Exception {
        Response respuesta = new Response("");
        ValidarPatente recursosPatente = new ValidarPatente();
        patenteService.buscarPatente(patente);
        if (recursosPatente.validarPatenteVieja(patente) || recursosPatente.validarPatenteNueva(patente)) {
            if (patenteService.buscarPatente(patente) != null) {
                patenteService.getPatente(patente);
                respuesta = new Response("Id = " + patenteService.buscarPatente(patente));
            } else {
                throw new NotFoundRequest("No se encontro la patente.");
            }
        } else {
            throw new BadRequestException("Formato de patente invalida");
        }
        return respuesta;
    }

    @PostMapping
    public Response savePatente(@RequestBody Request patenteRequest) throws Exception {
        Response respuesta = new Response("");
        ValidarPatente recursosPatente = new ValidarPatente();
        patenteService.buscarPatente(patenteRequest.getNroPatente());
        // Valido la patente
        if (recursosPatente.validarPatenteVieja(patenteRequest.getNroPatente())
                || recursosPatente.validarPatenteNueva(patenteRequest.getNroPatente())) {
            // Comprobar si existe
            if (patenteService.buscarPatente(patenteRequest.getNroPatente()) != null) {
                // Si existe devuelvo error "ya existe" y un MSG
                throw new NotModified("La patente ya existe en la BBDD");
            } else {
                // Si no existe, lo agrego y devuelvo COD 200 + MSG.
                patenteService.save(new ModeloPatente(patenteRequest.getNroPatente()));
                respuesta = new Response("No existe esa patente en nuestra base de datos, por lo tanto se agrega a nuestro registro.");
            }
        } else {
            throw new BadRequestException("Formato de patente invalida");
        }
        return respuesta;
    }
}
