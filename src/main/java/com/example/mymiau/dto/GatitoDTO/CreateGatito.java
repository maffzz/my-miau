package com.example.mymiau.dto.GatitoDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateGatito {
    @NotNull(message = " ¡! el nombre del gatito no puede ser nulo")
    private String nombre;

    @NotNull(message = " ¡! el año de nacimiento del gatito no puede ser nulo")
    @Size(min = 4, max = 4, message = " ¡! el año de nacimiento del gatito debe tener formado 'YYYY'")
    private Integer anioNacimiento;

    @NotNull(message = " ¡! el color del gatito no puede ser nulo")
    private String color;

    @NotNull(message = " ¡! el id del dueño del gatito no puede ser nulo")
    private Long duenio_id;}