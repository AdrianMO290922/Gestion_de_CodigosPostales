package com.cpostalesApi.Service;

import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.repository.MunicipioRepository;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Singleton;

@Singleton

public class MunicipioService {
    MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository){
        this.municipioRepository=municipioRepository;
    }

    public Municipio showById( String id_municipios){
     return municipioRepository.findById(id_municipios).orElse(null);
    }
}
