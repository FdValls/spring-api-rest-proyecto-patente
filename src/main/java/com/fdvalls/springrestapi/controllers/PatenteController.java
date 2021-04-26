package com.fdvalls.springrestapi.controllers;

import com.fdvalls.springrestapi.clasesExceptions.BadRequestException;
import com.fdvalls.springrestapi.clasesExceptions.NotFoundRequest;
import com.fdvalls.springrestapi.clasesExceptions.ValidarPatente;
import com.fdvalls.springrestapi.controllers.dto.Request;
import com.fdvalls.springrestapi.controllers.dto.ResponseGet;
import com.fdvalls.springrestapi.controllers.dto.ResponsePost;
import com.fdvalls.springrestapi.model.ModeloPatente;
import com.fdvalls.springrestapi.services.PatenteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseGet printPatente(@RequestParam("nroPatente") String patente) throws Exception {
        ValidarPatente recursosPatente = new ValidarPatente();
        if (recursosPatente.validarPatenteVieja(patente) || recursosPatente.validarPatenteNueva(patente)) {
            ModeloPatente modeloPatente = patenteService.getPatente(patente);
            if (modeloPatente != null) {
                return new ResponseGet(modeloPatente.getId());
            } else {
                throw new NotFoundRequest("No se encontro la patente.");
            }
        } else {
            throw new BadRequestException("Formato de patente invalida");
        }
    }

    @PostMapping
    public ResponseEntity<ResponsePost> savePatente(@RequestBody Request patenteRequest) throws Exception {
        ResponseEntity<ResponsePost> respuesta = null;
        ValidarPatente recursosPatente = new ValidarPatente();
        patenteService.getPatente(patenteRequest.getNroPatente());
        // Valido la patente
            if (recursosPatente.validarPatenteVieja(patenteRequest.getNroPatente())
                || recursosPatente.validarPatenteNueva(patenteRequest.getNroPatente())) {
            // Comprobar si existe
            if (patenteService.getPatente(patenteRequest.getNroPatente()) != null) {
                // Si existe devuelvo error "ya existe" y un MSG
                respuesta = ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
            } else {
                // Si no existe, lo agrego y devuelvo COD 200 + MSG.
                respuesta = ResponseEntity.ok().body(new ResponsePost(patenteService.save(new ModeloPatente(patenteRequest.getNroPatente()))));
            }
        } else {
            throw new BadRequestException("Formato de patente invalida");
        }
        return respuesta;
    }
}
