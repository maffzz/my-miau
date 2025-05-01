package com.example.mymiau.dto.UsuarioDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ResponseUsuario {
    private Long id;
    private String nombre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;
    private List<String> nombresGatitos;}