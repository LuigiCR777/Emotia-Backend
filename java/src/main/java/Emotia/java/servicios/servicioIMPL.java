package Emotia.java.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioIMPL implements ITservicio {

    @Autowired
    ITrepositorioUsuario repositorioUsuario;

    @Override
    public List<Usuarios> listaUsuarios() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Usuarios completarPerfil(CompletarPerfilRequest request) {

        Usuarios usuarioExistente = null;

        if (request.getId() != null) {
            usuarioExistente = repositorioUsuario.findById(request.getId()).orElse(null);
        } else if (request.getTelefono() != null) {
            usuarioExistente = repositorioUsuario.findByTelefono(request.getTelefono());
        }

        if (usuarioExistente == null) {
            throw new RuntimeException("Error: No se encontró el usuario.");
        }

        try {
            if (request.getNombre() != null) {
                usuarioExistente.setNombre(request.getNombre());
            }

            if (request.getApellido() != null) {
                usuarioExistente.setApellido(request.getApellido());
            }

            if (request.getUsuario() != null) {
                usuarioExistente.setUsuario(request.getUsuario());
            }

            if (request.getCorreo() != null) {
                usuarioExistente.setCorreo(request.getCorreo());
            }

            if (request.getNacimiento() != null) {
                usuarioExistente.setNacimiento(request.getNacimiento());
            }

            if (request.getPais() != null) {
                usuarioExistente.setPais(request.getPais());
            }

            if (request.getUsuario() != null) {
                usuarioExistente.setUsuario(request.getUsuario());
            }

            if (request.getContrasena() != null) {
                usuarioExistente.setContrasena(request.getContrasena());
            }

            return repositorioUsuario.save(usuarioExistente);

        } catch (Exception e) {
            System.out.println("Falló el sistema al actualizar perfil: " + e);
            throw new RuntimeException("No se pudo completar el perfil del usuario", e);
        }
    }
}