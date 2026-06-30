package Emotia.java.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.DiarioDto;
import Emotia.java.modelo.Diario;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioDiario;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioDiarioIMPL implements ITservicioDiario{

    @Autowired ITrepositorioDiario repositorioDiario;

    @Autowired ITrepositorioUsuario repositorioUsuario;

    @Override
    public Diario diario( DiarioDto dto) {

    System.out.println("DTO COMPLETO: " + dto);
    System.out.println("ID USUARIO: " + dto.getIdUsuario());

    Usuarios usuario = repositorioUsuario
        .findById(dto.getIdUsuario())
        .orElseThrow(() ->
            new RuntimeException("Usuario no encontrado"));

    Diario diario = new Diario();
    diario.setIdUsuarios(usuario);
    diario.setFecha(dto.getFecha());
    diario.setTitulo(dto.getTitulo());
    diario.setContenido(dto.getContenido());
    diario.setEstado(dto.getEstado());

    return repositorioDiario.save(diario);
    }

    @Override
    public List<Diario> diarios() {

        return repositorioDiario.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repositorioDiario.deleteById(id);
    }

    @Override
    public List<Diario> diariosPorUsuario(Long idUsuario) {
        return repositorioDiario.findByIdUsuarios_IdUsuario(idUsuario);
    }

    

    

}
