package com.example.mymiau.dto.GatitoDTO;

import com.example.mymiau.domain.GatitoColor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateGatito {
    @NotBlank(message = " ¡! el nombre del gatito no puede ser nulo")
    private String nombre;

    @NotNull(message = " ¡! el año de nacimiento no puede ser nulo")
    @Min(value = 1000, message = " ¡! el año debe tener formato 'YYYY'")
    @Max(value = 9999, message = " ¡! el año debe tener formato 'YYYY'")
    private Integer anioNacimiento;

    @NotNull(message = " ¡! el color del gatito no puede ser nulo")
    private GatitoColor color;

    @JsonProperty("duenio")
    @NotNull(message = " ¡! el id del dueño no puede ser nulo")
    private Long duenio;}