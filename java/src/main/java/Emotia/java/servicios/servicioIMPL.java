package Emotia.java.servicios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.dto.LogginRequest;
import Emotia.java.dto.OtpREquest;
import Emotia.java.modelo.Otp;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioOtp;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioIMPL implements ITservicio{

    @Autowired
    ITrepositorioUsuario repositorioUsuario;

    @Autowired
    ITrepositorioOtp repositorioOtp;
    

    @Override
    public List<Usuarios> listaUsuarios() {
        List<Usuarios> usuarios = repositorioUsuario.findAll();
        return usuarios;
    }


    @Override
    public Usuarios completarPerfil(CompletarPerfilRequest request) {

    // MODIFICADO: busca por id si viene, si no busca por teléfono
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
        // Solo actualiza los campos que vienen en el request (no pisa los nulos)
        if (request.getNombre() != null) usuarioExistente.setNombre(request.getNombre());
        if (request.getApellido() != null) usuarioExistente.setApellido(request.getApellido());
        if (request.getCorreo() != null) usuarioExistente.setCorreo(request.getCorreo());
        if (request.getNacimiento() != null) usuarioExistente.setNacimiento(request.getNacimiento());
        if (request.getPais() != null) usuarioExistente.setPais(request.getPais());

        return repositorioUsuario.save(usuarioExistente);

    } catch (Exception e) {
        System.out.println("Falló el sistema al actualizar perfil: " + e);
        throw new RuntimeException("No se pudo completar el perfil del usuario", e);
    }
}


        
}
