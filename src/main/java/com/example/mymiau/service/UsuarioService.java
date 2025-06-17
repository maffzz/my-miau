package com.example.mymiau.service;

import com.example.mymiau.domain.Usuario;
import com.example.mymiau.dto.UsuarioDTO.CreateUsuario;
import com.example.mymiau.dto.UsuarioDTO.ResponseUsuario;
import com.example.mymiau.dto.UsuarioDTO.UpdateUsuarioNombre;
import com.example.mymiau.exception.BadRequest;
import com.example.mymiau.exception.Conflict;
import com.example.mymiau.exception.NotFound;
import com.example.mymiau.mapper.UsuarioMapper;
import com.example.mymiau.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public List<ResponseUsuario> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());}

    public ResponseUsuario createUsuario(CreateUsuario dto) {
        if (usuarioRepository.existsByEmail(dto.getCorreo())) {
            throw new Conflict(" ¡! ya existe un usuario con ese correo");}
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre(dto.getNombre());
        usuarioNuevo.setEmail(dto.getCorreo());
        usuarioNuevo.setPassword(passwordEncoder.encode(dto.getContrasenia()));
        usuarioNuevo.setFechaRegistro(LocalDate.now());
        usuarioRepository.save(usuarioNuevo);
        return UsuarioMapper.toDTO(usuarioNuevo);}
    
    public ResponseUsuario updateNombreUsuario(Long id, UpdateUsuarioNombre dto) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFound(" ¡! no existe el usuario con el id " + id);}
        Usuario usuarioActu = usuarioRepository.findById(id).get();
        usuarioActu.setNombre(dto.getNombre());
        return UsuarioMapper.toDTO(usuarioActu);}
    
    public String deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFound(" ¡! no existe el usuario con el id " + id);}
        usuarioRepository.deleteById(id);
        return "usuario eliminado correctamente :D";}
    
    public ResponseUsuario getUsuarioById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFound(" ¡! no existe el usuario con el id " + id);}
        return UsuarioMapper.toDTO(usuarioRepository.findById(id).get());}

    public List<ResponseUsuario> getUsuarioByNombre(String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombre(nombre);
        if (usuarios == null) {
            throw new NotFound(" ¡! no existen usuarios con el nombre " + nombre);}
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());}

    public List<ResponseUsuario> getUsuariosByFechaRegistro(String fechaRegistro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate fecha = LocalDate.parse(fechaRegistro, formatter);
            List<Usuario> usuarios = usuarioRepository.findByFechaRegistro(fecha);
            if (usuarios == null) {
                throw new NotFound(" ¡! no existen usuarios registrados en la fecha " + fechaRegistro);}
            return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());}
        catch (DateTimeParseException e) {
            throw new BadRequest(" ¡! formato de fecha inválido. use el formato: yyyy-MM-dd");}}}