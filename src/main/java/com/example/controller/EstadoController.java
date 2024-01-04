package com.example.controller;

import com.example.entity.Estado;
import com.example.service.EstadoService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("/api/v1")
public class EstadoController {
    EstadoService estadoService;

    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;

    }
    @Get("estado/{id}")
    public Estado showById(@PathVariable int id){
    return estadoService.showById(id);
    }
    @Get("estados")
    public List<Estado> showAll(){
        return estadoService.showAll();
    }
    @Get("Saludo")
    public String Saludo(){
        return "Hi bitch";
    }

}
