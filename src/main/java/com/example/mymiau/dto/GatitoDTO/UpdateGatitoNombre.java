package com.example.mymiau.dto.GatitoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateGatitoNombre {
    @NotBlank(message = " ¡! asegúrate de ingresar el nuevo nombre del gatito")
    private String nombre;}