package com.example.mymiau.service;

import com.example.mymiau.domain.Gatito;
import com.example.mymiau.domain.GatitoColor;
import com.example.mymiau.domain.Usuario;
import com.example.mymiau.dto.GatitoDTO.CreateGatito;
import com.example.mymiau.dto.GatitoDTO.ResponseGatito;
import com.example.mymiau.dto.GatitoDTO.UpdateGatitoDuenio;
import com.example.mymiau.dto.GatitoDTO.UpdateGatitoNombre;
import com.example.mymiau.exception.NotFound;
import com.example.mymiau.mapper.GatitoMapper;
import com.example.mymiau.repository.GatitoRepository;
import com.example.mymiau.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GatitoService {
    private final GatitoRepository gatitoRepository;
    private final UsuarioRepository usuarioRepository;

    public List<ResponseGatito> getGatitos() {
        List<Gatito> gatitos = gatitoRepository.findAll();
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}

    public ResponseGatito createGatito(@NotNull CreateGatito dto) {
        Usuario duenio = usuarioRepository.findById(dto.getDuenio())
                .orElseThrow(() -> new NotFound( "¡! no existe el dueño con id " + dto.getDuenio()));
        Gatito gatito = new Gatito();
        gatito.setNombre(dto.getNombre());
        gatito.setAnioNacimiento(dto.getAnioNacimiento());
        gatito.setColor(dto.getColor());
        gatito.setDuenio(duenio);
        Gatito nuevoGatito = gatitoRepository.save(gatito);
        return GatitoMapper.toDTO(nuevoGatito);}

    public ResponseGatito updateGatitoNombre(Long id, @NotNull UpdateGatitoNombre dto) {
        Gatito gatitoActu = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFound(" ¡! no existe el gatito con el id " + id));
        gatitoActu.setNombre(dto.getNombre());
        gatitoRepository.save(gatitoActu);
        return GatitoMapper.toDTO(gatitoActu);}

    public ResponseGatito updateGatitoDuenio(Long id, @NotNull UpdateGatitoDuenio dto) {
        Gatito gatitoActu = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFound(" ¡! no existe el gatito con el id " + id));
        gatitoActu.setDuenio(usuarioRepository.findById(dto.getDuenio()).orElseThrow(
                () -> new NotFound(" ¡! no existe el dueño con el id " + dto.getDuenio())));
        gatitoRepository.save(gatitoActu);
        return GatitoMapper.toDTO(gatitoActu);}

    public String deleteGatito(Long id) {
        if (!gatitoRepository.existsById(id)) {
            throw new NotFound(" ¡! no existe el gatito con el id " + id);}
        gatitoRepository.deleteById(id);
        return "gatito eliminado correctamente :D";}

    public ResponseGatito getGatitoById(Long id) {
        return GatitoMapper.toDTO(gatitoRepository.findById(id).orElseThrow(
                () -> new NotFound(" ¡! no existe el gatito con el id " + id)));}

    public List<ResponseGatito> getGatitoByNombre(String nombre) {
        List<Gatito> gatitos = gatitoRepository.findByNombre(nombre);
        if (gatitos.isEmpty()) {
            throw new NotFound(
                    " ¡! no hay gatitos con este nombre");}
        return gatitos.stream().map(GatitoMapper::toDTO).toList();}

    public List<ResponseGatito> getGatitoByAnioNacimiento(Integer anio) {
        List<Gatito> gatitos = gatitoRepository.findByAnioNacimiento(anio);
        if (gatitos.isEmpty()) {
            throw new NotFound(
                    " ¡! no hay gatitos nacidos en este año");}
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}

    public List<ResponseGatito> getGatitoByColor(GatitoColor color) {
        List<Gatito> gatitos = gatitoRepository.findByColor(color);
        if (gatitos.isEmpty()) {
            throw new NotFound(
                    " ¡! no hay gatitos con este color");}
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}

    public List<ResponseGatito> getByDuenioID(Long id) {
        usuarioRepository.findById(id).orElseThrow(
                () -> new NotFound(
                        " ¡! usuario no encontrado con id " + id));
        List<Gatito> gatitos = gatitoRepository.findByDuenioId(id);
        if (gatitos.isEmpty()) {
            throw new NotFound(
                    " ¡! el usuario con id " + id + "no tiene gatitos");}
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}}