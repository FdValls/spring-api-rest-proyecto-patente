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

    public List<ModeloPatente> getAll() {
        return patenteRepository.getAll();
    }

    public void save(ModeloPatente patente) {
        patenteRepository.addRow(patente);
    }


}
