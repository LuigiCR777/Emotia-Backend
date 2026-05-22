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

    @Autowired
    private ITrepositorioOtp repositorioOtp;

    // =========================
    // TEST USUARIOS
    // =========================
    @GetMapping("/usuarios")
    public List<Usuarios> listarUsuarios() {

        return repositorioUsuario.findAll();
    }

    // =========================
    // TEST OTP
    // =========================
    @GetMapping("/otp")
    public List<Otp> listarOtp() {

        return repositorioOtp.findAll();
    }

    // =========================
    // ENVIAR OTP
    // =========================
    /*@PostMapping("/enviar-otp")
    public ResponseEntity<?> enviarOtp(@RequestBody OtpREquest request) {

    servicio.enviarotp(request);

    return ResponseEntity.ok(
            java.util.Map.of(
                    "status", "OK",
                    "message", "OTP enviado correctamente"
            )
    );
}

    // =========================
    // VALIDAR OTP
    // =========================
    @PostMapping("/validar-otp")
    public ResponseEntity<?> validarOtp(@RequestBody LogginRequest request) {

    boolean valido = servicio.ValidarOtp(request);

    if (valido) {
        return ResponseEntity.ok(
                java.util.Map.of(
                        "status", "OK",
                        "message", "Ingreso correcto"
                )
    );
}

    return ResponseEntity.badRequest().body(
            java.util.Map.of(
                    "status", "ERROR",
                    "message", "OTP incorrecto o expirado"
            )
        );
    } */

    // =========================
    // COMPLETAR PERFIL
    // =========================
    @PostMapping("/completar-perfil")
    public ResponseEntity<?> completarPerfil(
            @RequestBody CompletarPerfilRequest request) {

        Usuarios usuario =
                servicio.completarPerfil(request);

        if (usuario != null) {

            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity
                .badRequest()
                .body("Usuario no encontrado");
    }
}