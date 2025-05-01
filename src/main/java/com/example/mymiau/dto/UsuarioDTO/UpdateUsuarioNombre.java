package com.example.mymiau.dto.UsuarioDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUsuarioNombre {
    @NotNull(message = " ¡! el nombre del gatito no puede ser nulo")
    private String nombre;}