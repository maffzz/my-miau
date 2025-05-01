package com.example.mymiau.dto.UsuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUsuario {
    @NotBlank(message = " ¡! el nombre del usuario no puede ser nulo")
    private String nombre;

    @NotBlank(message = " ¡! el correo del usuario no puede ser nulo")
    @Email(message = " ¡! el correo del usuario debe tener un formato válido")
    private String correo;

    @NotBlank(message = " ¡! la contraseña del usuario no puede ser nula")
    private String contrasenia;}