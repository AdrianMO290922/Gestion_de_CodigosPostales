package com.example.controller;

import com.example.DTOs.EstadoDto;
import com.example.DTOs.MunicipioDto;
import com.example.entity.Estado;
import com.example.entity.Municipio;
import com.example.payload.MensajeResponse;
import com.example.service.EstadoService;
import com.example.service.MunicipioService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/api/v1")
public class EstadoController {
    EstadoService estadoService;
    MensajeResponse mensajeResponse;
    HttpResponse<MensajeResponse> HttpResponse;
/////////////////////////////Inyección de Dependencias///////////////////////////
    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    @Get("/estado/{id_estado}")
    public HttpResponse<?> mostrarEstado(@PathVariable Integer id_estado){
        try {
            Estado estado = estadoService.showById(id_estado);
            if (estado == null){
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontro el Estado solicitado").estado(null).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
            else {
                mensajeResponse = MensajeResponse.builder().error(false).mensaje("Estado caragado 1").estado(estado).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
        }catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).estado(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);

        }
    }


    @Get("/estados")
    public HttpResponse<?> mostrarEstados(){
        try {
            List<Estado> list = estadoService.showAll();
            int tamaño = list.size();
            if (list == null) {
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron estados").build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            } else {
                mensajeResponse = MensajeResponse.builder().error(false).estados(list).mensaje("Estados cargados " + tamaño).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
        }catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).estados(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }
    }



}
