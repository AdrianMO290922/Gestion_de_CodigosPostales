package com.cpostalesApi.controller;

import com.cpostalesApi.Service.EstadoService;
import com.cpostalesApi.entity.Estado;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("/api/v1")
public class EstadoController {

    EstadoService estadoService;

    public EstadoController (EstadoService estadoService){
        this.estadoService=estadoService;
    }

    @Get("/estado/{id_estado}")
    public Estado showById(@PathVariable int id_estado){
       return estadoService.showById(id_estado);
    }
    @Get("/saludar")
    public String saludar(){
        return "feliz navidad";
    }

    @Get("/estados")
    public List<Estado> showAll(){
        return estadoService.showAll();
    }

}
