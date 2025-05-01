package com.example.mymiau.repository;

import com.example.mymiau.domain.Gatito;
import com.example.mymiau.domain.GatitoColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GatitoRepository extends JpaRepository<Gatito, Long> {
    List<Gatito> findByNombre(String nombre);
    List<Gatito> findByAnioNacimiento(Integer anioNacimiento);
    List<Gatito> findByColor(GatitoColor color);
    List<Gatito> findByDuenioId(Long duenioId);}