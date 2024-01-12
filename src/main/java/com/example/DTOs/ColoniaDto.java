package com.example.DTOs;

import com.example.entity.CP;
import com.example.entity.Colonia;
import com.example.entity.Estado;
import com.example.entity.Municipio;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Serdeable.Serializable
public class ColoniaDto {



    private Integer estado_id;
    private Integer municipio_id;
    private String estado;
    private String municipio;
    private String colonia;
    private Integer codigo_postal;
    private LocalDate fecha_Act;



}
