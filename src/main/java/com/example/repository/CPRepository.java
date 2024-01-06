package com.example.repository;

import com.example.entity.CP;
import com.example.entity.Municipio;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
@Repository
public interface CPRepository extends JpaRepository<CP, Municipio> {
}
