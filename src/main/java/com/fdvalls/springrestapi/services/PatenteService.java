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

    public void save(ModeloPatente patente) {
        patenteRepository.addRow(patente);
    }

    public Long buscarPatente(String patente) {
        boolean seEncontro = false;
        Long myId = null;
        List<ModeloPatente> misPatentes = getAllPatente();
        int i = 0;
        while (i < misPatentes.size() && !seEncontro) {
            if (misPatentes.get(i).getNroPatente().toUpperCase().equals(patente.toUpperCase())) {
                seEncontro = true;
                myId = misPatentes.get(i).getId();
            } else {
                i++;
            }
        }
        return myId;
    }

}
