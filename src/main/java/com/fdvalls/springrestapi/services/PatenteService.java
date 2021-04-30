package com.fdvalls.springrestapi.services;

import java.util.List;

import com.fdvalls.springrestapi.database.Repositorio;
import com.fdvalls.springrestapi.model.ModeloPatente;

import org.springframework.stereotype.Service;

@Service
public class PatenteService {

    private final Repositorio patenteRepository;

    public PatenteService(Repositorio patenteRepository) {
        this.patenteRepository = patenteRepository;
    }

    public List<ModeloPatente> getAllPatente() {
        return patenteRepository.getAllPatente();
    }

    public ModeloPatente getPatente(String patente) {
        return patenteRepository.getPatente(patente);
    }

    public Number save(ModeloPatente patente) {
        return patenteRepository.addRow(patente);
    }

}
