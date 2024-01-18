package com.example.entity;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipios")
@Serdeable.Serializable
public class Municipio {
    @Id
    @Column(name = "Id_Municipios")
    private Integer id_municipios;

    @Column(name = "Municipios")
    private String municipios;

    @ManyToOne
    @JoinColumn(name = "Id_Estados")
    private Estado estado;

}
