package com.cpostalesApi.Service;

import com.cpostalesApi.entity.Estado;
import com.cpostalesApi.repository.EstadoRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class    EstadoService {

    EstadoRepository estadoRepository;

    public EstadoService (EstadoRepository estadoRepository){
        this.estadoRepository=estadoRepository;
    }

    public Estado showById(int id_estado){
        return estadoRepository.findById(id_estado).orElse(null);
    }
    public List<Estado> showAll(){
        return estadoRepository.findAll();
    }
}
