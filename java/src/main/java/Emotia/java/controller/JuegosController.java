package Emotia.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.dto.JuegosDto;
import Emotia.java.servicios.ITservicioJuegos;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/juegos")
public class JuegosController {

    @Autowired
    ITservicioJuegos juegos;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody JuegosDto dto) {

        return ResponseEntity.ok(juegos.juegubis(dto));
    }

}


   


