package com.example.mymiau;

import com.example.mymiau.domain.Gatito;
import com.example.mymiau.domain.GatitoColor;
import com.example.mymiau.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DomainTest {
    private Usuario usuario;
    private Gatito gatito;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setNombre("uniqua");
        usuario.setCorreo("uniqua@gmail.com");
        usuario.setContrasenia("contrasenia");
        gatito = new Gatito();
        gatito.setNombre("gatito");
        gatito.setColor(GatitoColor.blanco);
        gatito.setAnioNacimiento(2021);
        gatito.setDuenio(usuario);
        usuario.getGatitos().add(gatito);}

    @Test
    void testCreation() {
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("uniqua", usuario.getNombre());
        Assertions.assertEquals("uniqua@gmail.com", usuario.getCorreo());
        Assertions.assertEquals("contrasenia", usuario.getContrasenia());
        Assertions.assertEquals(1, usuario.getGatitos().size());
        Assertions.assertEquals("gatito", gatito.getNombre());
        Assertions.assertEquals(GatitoColor.blanco, gatito.getColor());
        Assertions.assertEquals(2021, gatito.getAnioNacimiento());
        Assertions.assertEquals(usuario, gatito.getDuenio());
        Assertions.assertEquals(usuario.getId(), gatito.getDuenio().getId());}}