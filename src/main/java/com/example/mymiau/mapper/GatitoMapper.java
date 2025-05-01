package com.example.mymiau.mapper;

import com.example.mymiau.domain.Gatito;
import com.example.mymiau.dto.GatitoDTO.ResponseGatito;

public class GatitoMapper {
    public static ResponseGatito toDTO(Gatito gatito) {
        ResponseGatito dto = new ResponseGatito();
        dto.setNombreDuenio(gatito.getDuenio().getNombre());
        dto.setId(gatito.getId());
        dto.setNombre(gatito.getNombre());
        dto.setColor(gatito.getColor().name());
        dto.setAnioNacimiento(gatito.getAnioNacimiento());
        return dto;}}