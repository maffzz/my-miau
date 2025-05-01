package com.example.mymiau.dto.GatitoDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateGatitoNombre {
    @NotNull(message = " ¡! asegúrate de ingresar el nuevo nombre del gatito")
    private String nombre;}