package com.example.repository;

import com.example.entity.CP;
import com.example.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Set;

@Repository
public interface CPRepository extends JpaRepository<CP, Integer> {
    @Query("SELECT m from CP m JOIN FETCH m.municipio WHERE m.municipio.id_municipios = :id")
    Set<CP> findMun(Integer id);

}
