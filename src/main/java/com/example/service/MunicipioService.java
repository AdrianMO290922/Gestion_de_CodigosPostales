package com.example.service;

import com.example.entity.Municipio;
import com.example.repository.MunicipioRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Set;

@Singleton
public class MunicipioService {
    MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository){
    this.municipioRepository = municipioRepository;
        }

    public Municipio showById(Integer id_municipio){
        return municipioRepository.findById(id_municipio).orElse(null);

    }
    public List<Municipio> showAll(){
        return municipioRepository.findAll();
    }
  public Set<Municipio> showMunPorEdo(Integer id_estado) {
        return municipioRepository.showMunPorEdo(id_estado);
    }

}
