package Emotia.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.dto.DiarioDto;
import Emotia.java.dto.EjercicioDTO;
import Emotia.java.servicios.ITservicioDiario;
import Emotia.java.servicios.ITservicioEjercicioRespiracion;

@RestController
@CrossOrigin("*")
@RequestMapping("api/ejercicios")
public class EjerciciosController {

    @Autowired
    private ITservicioEjercicioRespiracion ejercicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody EjercicioDTO dto) {

        return ResponseEntity.ok(ejercicio.respiracion(dto));
    }


}
