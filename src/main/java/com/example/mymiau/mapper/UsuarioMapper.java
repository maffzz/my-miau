
package com.example.mymiau.mapper;

import com.example.mymiau.domain.Gatito;
import com.example.mymiau.domain.Usuario;
import com.example.mymiau.dto.UsuarioDTO.ResponseUsuario;

import java.util.List;

public class UsuarioMapper {
    public static ResponseUsuario toDTO(Usuario usuario) {
    List<String> nombres = usuario.getGatitos().stream()
            .map(Gatito::getNombre)
            .toList();
    ResponseUsuario dto = new ResponseUsuario();
    dto.setId(usuario.getId());
    dto.setNombre(usuario.getNombre());
    dto.setFechaRegistro(usuario.getFechaRegistro());
    dto.setNombresGatitos(nombres);
    return dto;}}