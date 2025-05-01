package com.example.mymiau.dto.UsuarioDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUsuarioNombre {
    @NotBlank(message = " ¡! el nombre del gatito no puede ser nulo")
    private String nombre;}