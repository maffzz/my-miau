package com.example.mymiau.controller;

import com.example.mymiau.dto.UsuarioDTO.CreateUsuario;
import com.example.mymiau.dto.UsuarioDTO.ResponseUsuario;
import com.example.mymiau.dto.UsuarioDTO.UpdateUsuarioNombre;
import com.example.mymiau.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/todos")
    public ResponseEntity<List<ResponseUsuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());}

    @PostMapping("/crear")
    public ResponseEntity<ResponseUsuario> createUsuario(@Valid @RequestBody CreateUsuario dto) {
        return ResponseEntity.status(201).body(usuarioService.createUsuario(dto));}

    @PatchMapping("/{id}/updatenom")
    public ResponseEntity<ResponseUsuario> updateNombreUsuario(@Valid@PathVariable Long id, @Valid @RequestBody UpdateUsuarioNombre dto) {
        return ResponseEntity.ok(usuarioService.updateNombreUsuario(id, dto));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.deleteUsuario(id));}

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuario> getUsuarioById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));}

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ResponseUsuario>> getUsuarioByNombre(@Valid @PathVariable String nombre) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNombre(nombre));}

    @GetMapping("/fecharegistro/{fechaRegistro}")
    public ResponseEntity<List<ResponseUsuario>> getUsuarioByFechaRegistro(@Valid @PathVariable String fechaRegistro) {
        return ResponseEntity.ok(usuarioService.getUsuariosByFechaRegistro(fechaRegistro));}}