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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GatitoService {
    private final GatitoRepository gatitoRepository;
    private final UsuarioRepository usuarioRepository;

    List<Gatito> getGatitos() {
        return gatitoRepository.findAll();}

    public ResponseGatito createGatito(CreateGatito dto) {
        if (!usuarioRepository.existsById(dto.getDuenio_id())) {
            throw new NotFound(" ¡! no existe el dueño con el id " + dto.getDuenio_id());}
        Gatito gatitoNuevo = new Gatito();
        gatitoNuevo.setNombre(dto.getNombre());
        gatitoNuevo.setAnioNacimiento(dto.getAnioNacimiento());
        gatitoNuevo.setColor(dto.getColor());
        gatitoRepository.save(gatitoNuevo);
        System.out.println("gatito creado correctamente :D");
        return GatitoMapper.toDTO(gatitoNuevo);}

    public ResponseGatito UpdateGatitoNombre(Long id, UpdateGatitoNombre dto) {
        Gatito gatitoActu = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFound(" ¡! no existe el gatito con el id " + id));
        gatitoActu.setNombre(dto.getNombre());
        System.out.println("gatito actualizado correctamente :D");
        return GatitoMapper.toDTO(gatitoActu);}

    public ResponseGatito UpdateGatitoDuenio(Long id, UpdateGatitoDuenio dto) {
        // maybe me hice bolas
        Gatito gatitoActu = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFound(" ¡! no existe el gatito con el id " + id));
         Optional<Usuario> noDuenio = usuarioRepository.findById(gatitoActu.getDuenio().getId());
        gatitoActu.setDuenio(usuarioRepository.findById(dto.getNewDuenio_id()).orElseThrow(
                () -> new NotFound(" ¡! no existe el dueño con el id " + dto.getNewDuenio_id())));
         noDuenio.get().getGatitos().remove(gatitoActu);
         Optional<Usuario> nuevoDuenio = usuarioRepository.findById(dto.getNewDuenio_id());
         nuevoDuenio.get().getGatitos().add(gatitoActu);
        System.out.println("gatito actualizado correctamente :D");
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
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}

    public List<ResponseGatito> getGatitoByAnioNacimiento(Integer anio) {
        List<Gatito> gatitos = gatitoRepository.findByAnioNacimiento(anio);
        if (gatitos.isEmpty()) {
            throw new NotFound(
                    " ¡! no hay gatitos nacidos en este año");}
        return gatitos.stream()
                .map(GatitoMapper::toDTO)
                .toList();}

    public List<ResponseGatito> getGatitoColor(GatitoColor color) {
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