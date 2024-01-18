package com.example.controller;

import com.example.DTOs.CPDto;
import com.example.DTOs.ColoniaDto;
import com.example.entity.CP;
import com.example.entity.Colonia;
import com.example.entity.Estado;
import com.example.entity.Municipio;
import com.example.payload.MensajeResponse;
import com.example.service.CPService;
import com.example.service.ColoniaService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/api/v1")
public class ColoniaController {
    ColoniaService coloniaService;
    CPService cpService;
    MensajeResponse mensajeResponse;
    HttpResponse<MensajeResponse> HttpResponse;

    public ColoniaController(ColoniaService coloniaService, CPService cpService){
        this.coloniaService = coloniaService;
        this.cpService = cpService;
    }

    @Get("/colonias/estado/{id_edo}/municipio/{id_mun}")
    public HttpResponse<?> mostrarColoniasEdoMu(@PathVariable Integer id_edo, @PathVariable Integer id_mun){
        try{
            ;
            List<Colonia> colColonias = coloniaService.showColEdoMun(id_edo,id_mun);
            List<ColoniaDto> coloniaDtos = colColonias.stream()
                    .map(colonia -> ColoniaDto.builder()
                            .estado_id(colonia.getCp().getMunicipio().getEstado().getId_estado())
                            .municipio_id(colonia.getCp().getMunicipio().getId_municipios())
                            .codigo_postal(colonia.getCp().getCp())
                            .colonia(colonia.getColonia())
                            .fecha_Act(LocalDate.now())
                            .build()
                    )
                    .collect(Collectors.toList());
            if (colColonias == null){
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron colonias").codigo_postal(null).build();
                return  io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
            else {
                mensajeResponse = MensajeResponse.builder().error(false).mensaje("Se cargaron "+coloniaDtos.size()+" colonias").colonias(coloniaDtos).build();
                return  io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }

        }catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).codigo_postal(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }

    }


    @Get("colonias/codigo_postal/{codigo}")
    public HttpResponse<?> mostrarColoniasCp(@PathVariable Integer codigo){
        try {
            Set<Colonia> colColonias =coloniaService.showColCp(codigo);
            List<ColoniaDto> listColDto = colColonias.stream()
                    .map(colonia -> ColoniaDto.builder()
                            .estado_id(colonia.getCp().getMunicipio().getEstado().getId_estado())
                            .municipio_id(colonia.getCp().getMunicipio().getId_municipios())
                            .estado(colonia.getCp().getMunicipio().getEstado().getEstado())
                            .municipio(colonia.getCp().getMunicipio().getMunicipios())
                            .codigo_postal(colonia.getCp().getCp())
                            .colonia(colonia.getColonia())
                            .build())
                    .collect(Collectors.toList());

            if (colColonias == null){
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron Colonias").colonias(null).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }else{
                int tamaño = listColDto.size();
                mensajeResponse = MensajeResponse.builder().error(false).mensaje("Colonias cargadas "+tamaño).colonias(listColDto).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
        }catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).colonias(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);

        }
    }
}
