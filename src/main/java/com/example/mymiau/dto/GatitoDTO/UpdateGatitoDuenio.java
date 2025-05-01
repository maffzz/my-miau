package com.example.mymiau.dto.GatitoDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateGatitoDuenio {
    @NotNull(message = " ¡! asegúrate de ingresar el id del nuevo dueño del gatito")
    private Long duenio;}