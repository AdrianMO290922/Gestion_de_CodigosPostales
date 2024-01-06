package com.example.repository;

import com.example.entity.CP;
import com.example.entity.Colonia;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, CP> {
}
