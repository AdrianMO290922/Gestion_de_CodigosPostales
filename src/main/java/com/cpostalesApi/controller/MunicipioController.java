package com.cpostalesApi.controller;

import com.cpostalesApi.Service.MunicipioService;
import com.cpostalesApi.entity.Municipio;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("api/v1")
public class MunicipioController {

    MunicipioService municipioService;

    public MunicipioController (MunicipioService municipioService){
        this.municipioService=municipioService;
    }

    @Get("/municipio/{id_municipio}")

    public Municipio showMunicipio(@PathVariable String id_municipio){
        return municipioService.showById(id_municipio);
    }
}
