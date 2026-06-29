package Emotia.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import Emotia.java.dto.DiarioDto;
import Emotia.java.modelo.Diario;
import Emotia.java.servicios.ITservicioDiario;

@RestController
@RequestMapping("/api/diario")
@CrossOrigin("*")
public class DiarioController {

    @Autowired
    private ITservicioDiario servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody DiarioDto dto) {

        return ResponseEntity.ok(
                servicio.diario(dto)
        );
    }

    @GetMapping
    public List<Diario> listar() {

        return servicio.diarios();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        servicio.eliminar(id);
    }
}