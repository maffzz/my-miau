package com.example.mymiau.dto.GatitoDTO;

import lombok.Data;

@Data
public class ResponseGatito {
    private Long id;
    private String nombre;
    private Integer anioNacimiento;
    private String color;
    private String nombreDuenio;}