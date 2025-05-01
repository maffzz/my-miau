package com.example.mymiau.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gatito")
public class Gatito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer anioNacimiento;

    @Enumerated(EnumType.STRING)
    private GatitoColor color;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario duenio;}