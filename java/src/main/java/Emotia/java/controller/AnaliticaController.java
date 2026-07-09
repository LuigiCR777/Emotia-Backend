package Emotia.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.dto.AnaliticaIARequestDTO;
import Emotia.java.modelo.Respuestas_test;
import Emotia.java.modelo.analitica_test;
import Emotia.java.repositorio.ITrepositorioAnaliticaTest;
import Emotia.java.repositorio.ITrespuestas;

@RestController
@RequestMapping("/api/analitica-ia")
@CrossOrigin(origins = "*") // Permitir solicitudes desde cualquier origen (ajustar según necesidades)
public class AnaliticaController {

    @Autowired
    private ITrepositorioAnaliticaTest repository;

    @Autowired
    private ITrespuestas respuestas;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarAnaliticaFrame(
        @RequestBody AnaliticaIARequestDTO dto) {

    try {

        System.out.println(
            "ID RESPUESTA RECIBIDO: " + dto.getIdRespuesta()
        );

        analitica_test registro = new analitica_test();

        Respuestas_test respuesta = respuestas
        .findById(dto.getIdRespuesta())
        .orElseThrow(() ->
            new RuntimeException(
                "No existe la respuesta con ID: "
                + dto.getIdRespuesta()
            ));

        registro.setIdrespuesta(respuesta);
        registro.setTimestampVideo(dto.getTimestampVideo());
        registro.setEmociondetectada(dto.getEmocionDetectada());
        registro.setProbabilidades(dto.getProbabilidades());

        repository.save(registro);

        return ResponseEntity.ok().build();

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
public ResponseEntity<?> listarAnalitica() {

    try {

        return ResponseEntity.ok(repository.findAll());

    } catch (Exception e) {

        e.printStackTrace();

        return ResponseEntity.internalServerError()
                .body(e.getMessage());

    }

}
}
