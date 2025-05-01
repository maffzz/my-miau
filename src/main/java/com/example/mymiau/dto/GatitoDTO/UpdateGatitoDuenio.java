package com.example.mymiau.dto.GatitoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateGatitoDuenio {
    @NotBlank(message = " ¡! asegúrate de ingresar el id del nuevo dueño del gatito")
    private Long newDuenio_id;}