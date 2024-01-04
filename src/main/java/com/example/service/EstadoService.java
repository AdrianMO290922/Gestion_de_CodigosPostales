package com.example.service;

import com.example.entity.Estado;
import com.example.repository.EstadoRepository;
import jakarta.inject.Singleton;

import java.util.List;
@Singleton
public class EstadoService {
    EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }
    public Estado showById(int id_Estado){
        return estadoRepository.findById(id_Estado).orElse(null);
    }

    public List<Estado> showAll(){
        return estadoRepository.findAll();
    }


}
