package Emotia.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.dto.LogginRequest;
import Emotia.java.modelo.Usuarios;
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

    @GetMapping("/ping")
    public String ping() {
        return "REGISTRO CONTROLLER ACTIVO";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LogginRequest request) {

        if (request.getUsuario() == null || request.getUsuario().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El usuario es obligatorio");
        }

        if (request.getContrasena() == null || request.getContrasena().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La contraseña es obligatoria");
        }

        Usuarios usuario = repositorioUsuario.findByUsuario(request.getUsuario());

        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        if (!usuario.getContrasena().equals(request.getContrasena())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody CompletarPerfilRequest request) {

        if (request.getUsuario() == null || request.getUsuario().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El usuario es obligatorio");
        }

        if (request.getContrasena() == null || request.getContrasena().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La contraseña es obligatoria");
        }

        Usuarios existe = repositorioUsuario.findByUsuario(request.getUsuario());

        if (existe != null) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        Usuarios usuario = new Usuarios();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());
        usuario.setUsuario(request.getUsuario());
        usuario.setContrasena(request.getContrasena());
        usuario.setPais(request.getPais());
        usuario.setNacimiento(request.getNacimiento());

        usuario = repositorioUsuario.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/completar")
    public ResponseEntity<?> completar(@RequestBody CompletarPerfilRequest request) {
        return ResponseEntity.ok(servicio.completarPerfil(request));
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<?> obtenerPerfil(@PathVariable Long id) {

        Usuarios usuario = repositorioUsuario.findById(id).orElse(null);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }
}