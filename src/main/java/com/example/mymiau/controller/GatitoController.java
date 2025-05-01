package com.example.mymiau.controller;

import com.example.mymiau.domain.GatitoColor;
import com.example.mymiau.dto.GatitoDTO.CreateGatito;
import com.example.mymiau.dto.GatitoDTO.ResponseGatito;
import com.example.mymiau.dto.GatitoDTO.UpdateGatitoDuenio;
import com.example.mymiau.dto.GatitoDTO.UpdateGatitoNombre;
import com.example.mymiau.service.GatitoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatito")
@RequiredArgsConstructor
public class GatitoController {
    private final GatitoService gatitoService;

    @GetMapping("/todos")
    public ResponseEntity<List<ResponseGatito>> getGatitos() {
        return ResponseEntity.ok(gatitoService.getGatitos());}

    @PostMapping("/crear")
    public ResponseEntity<ResponseGatito> createGatito(@Valid @RequestBody CreateGatito dto) {
        return ResponseEntity.ok(gatitoService.createGatito(dto));}

    @PatchMapping("/{id}/updatenom")
    public ResponseEntity<ResponseGatito> updateGatitoNombre(@Valid @PathVariable Long id, @Valid @RequestBody UpdateGatitoNombre dto) {
        return ResponseEntity.ok(gatitoService.updateGatitoNombre(id, dto));}

    @PatchMapping("/{id}/updateduenio")
    public ResponseEntity<ResponseGatito> updateGatitoDuenio(@Valid @PathVariable Long id, @Valid @RequestBody UpdateGatitoDuenio dto) {
        return ResponseEntity.ok(gatitoService.updateGatitoDuenio(id, dto));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGatito(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(gatitoService.deleteGatito(id));}

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGatito> getGatitoById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(gatitoService.getGatitoById(id));}

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ResponseGatito>> getGatitoByNombre(@Valid @PathVariable String nombre) {
        return ResponseEntity.ok(gatitoService.getGatitoByNombre(nombre));}

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<ResponseGatito>> getGatitoByAnioNacimiento(@Valid @PathVariable Integer anio) {
        return ResponseEntity.ok(gatitoService.getGatitoByAnioNacimiento(anio));}

    @GetMapping("/color/{color}")
    public ResponseEntity<List<ResponseGatito>> getGatitoByColor(@Valid @PathVariable GatitoColor color) {
        return ResponseEntity.ok(gatitoService.getGatitoByColor(color));}

    @GetMapping("/duenio/{id}")
    public ResponseEntity<List<ResponseGatito>> getByDuenioID(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(gatitoService.getByDuenioID(id));}}