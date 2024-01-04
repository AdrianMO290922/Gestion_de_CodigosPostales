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
@Table (name = "estados")
@Serdeable.Serializable
public class Estado {

    @Id
    @Column(name = "Id_Estados")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;
    @Column(name = "Estados")
    private String estado;
}
