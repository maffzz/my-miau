package com.example.mymiau.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String contrasenia;

    private LocalDate fechaRegistro = LocalDate.now();

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
    private List<Gatito> gatitos;}