package Emotia.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.dto.LogginRequest;
import Emotia.java.dto.OtpREquest;
import Emotia.java.modelo.Otp;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioOtp;
import Emotia.java.repositorio.ITrepositorioUsuario;
import Emotia.java.servicios.ITservicio;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class RegistroController {

    @Autowired
    private ITservicio servicio;

    @Autowired
    private ITrepositorioUsuario repositorioUsuario;

    // ==========================
    // VERIFICAR Y GUARDAR NUMERO
    //===========================
    @PostMapping("/firebase-login")
    public ResponseEntity<?> firebaseLogin(
            @RequestBody LogginRequest request) {

        String telefono = request.getTelefono();
        
        Usuarios usuario = repositorioUsuario.findByTelefono(telefono);

        if (usuario == null) {

            usuario = new Usuarios();
            usuario.setTelefono(telefono);
        }

        usuario = repositorioUsuario.save(usuario);
        
    return ResponseEntity.ok(usuario);
    }
    
    // =========================
    // COMPLETAR PERFIL
    // =========================
    @PostMapping("/completar")
    public ResponseEntity<?> completar(@RequestBody CompletarPerfilRequest request) {

        return ResponseEntity.ok(servicio.completarPerfil(request));
    }   

    
    // =========================
    // OBTENER PERFIL DESDE POSTGRESQL POR TELÉFONO
    // =========================
   @GetMapping("/perfil/{id}")
    public ResponseEntity<?> obtenerPerfil(@PathVariable Long id) {

    // Usamos el método estándar de Spring Data JPA (findById)
    // que devuelve un Optional, por lo que usamos .orElse(null) para mantener tu lógica
    Usuarios usuario = repositorioUsuario.findById(id).orElse(null);

    if (usuario == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(usuario);
    }

}