package Emotia.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Emotia.java.dto.RespuestaTestDTO;
import Emotia.java.modelo.Respuestas_test;
import Emotia.java.servicios.servicioRespuestaIMPL;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin(origins = "*")
public class RespuestaTestController {

    @Autowired
    private servicioRespuestaIMPL respuestaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarRespuesta(
            @RequestBody RespuestaTestDTO dto) {

        try {

            Respuestas_test guardada =
                    respuestaService.guardar(dto);

            return ResponseEntity.ok(
                Map.of(
                    "status", "success",
                    "message", "Respuesta guardada correctamente",
                    "idRespuesta", guardada.getId_respuesta()
                )
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError().body(
                Map.of(
                    "status", "error",
                    "message", e.getMessage()
                )
            );
        }
    }
}