package com.example.mymiau.dto.UsuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUsuario {
    @NotNull(message = " ¡! el nombre del usuario no puede ser nulo")
    private String nombre;

    @NotNull(message = " ¡! el correo del usuario no puede ser nulo")
    @Email(message = " ¡! el correo del usuario debe tener un formato válido")
    private String correo;

    @NotNull(message = " ¡! la contraseña del usuario no puede ser nula")
    private String contrasenia;}