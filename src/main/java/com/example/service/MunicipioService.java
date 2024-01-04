package com.example.service;

import com.example.entity.Municipio;
import com.example.repository.MunicipioRepository;
import jakarta.inject.Singleton;

import java.util.List;
@Singleton
public class MunicipioService {
    MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository){
    this.municipioRepository = municipioRepository;
        }

    public Municipio showById(int id_municipio){
        return municipioRepository.findById(id_municipio).orElse(null);

    }
  public List<Municipio> showMunPorEdo(Integer id_estado) {
        return municipioRepository.showMunPorEdo(id_estado);
    }
    public List<Municipio> showAll(){
        return municipioRepository.findAll();
    }
}
