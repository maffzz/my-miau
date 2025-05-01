package com.example.mymiau.dto.GatitoDTO;

import com.example.mymiau.domain.GatitoColor;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateGatito {
    @NotBlank(message = " ¡! el nombre del gatito no puede ser nulo")
    private String nombre;

    @NotBlank(message = " ¡! el año de nacimiento del gatito no puede ser nulo")
    @Size(min = 4, max = 4, message = " ¡! el año de nacimiento del gatito debe tener formado 'YYYY'")
    private Integer anioNacimiento;

    @NotBlank(message = " ¡! el color del gatito no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private GatitoColor color;

    @NotBlank(message = " ¡! el id del dueño del gatito no puede ser nulo")
    private Long duenio_id;}