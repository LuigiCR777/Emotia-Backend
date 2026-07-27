package Emotia.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.dto.DiarioDto;
import Emotia.java.dto.TecnicaDTO;
import Emotia.java.servicios.ITservicioTecnica;

@RestController
@CrossOrigin("*")
@RequestMapping("api/tecnica")
public class TecnicaController {

    @Autowired
    ITservicioTecnica tecnica;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody TecnicaDTO dto) {

        return ResponseEntity.ok(tecnica.tecnica(dto)
        );
    }

}
