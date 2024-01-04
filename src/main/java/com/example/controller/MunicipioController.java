package com.example.controller;

import com.example.entity.Municipio;
import com.example.service.MunicipioService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("api/v1")
public class MunicipioController {
    MunicipioService municipioService;
    public MunicipioController(MunicipioService municipioService){
        this.municipioService = municipioService;
    }

    @Get("municipios")
    public List<Municipio> showAll(){
        return municipioService.showAll();
    }

    @Get("municipio/{id_estado}")
    public List<Municipio> showById(@PathVariable Integer id_estado){
        return municipioService.showMunPorEdo(id_estado);
    }
}
