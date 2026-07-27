package Emotia.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.dto.TestsEmocionalesDto;
import Emotia.java.modelo.Test_emocional;
import Emotia.java.servicios.ITservicioTest; // Importamos la interfaz del servicio

@RestController
@RequestMapping("/testemocional")
@CrossOrigin(origins = "*")
public class TestEmocionalController {

    // Inyectamos el servicio que maneja la lógica y la persistencia
    @Autowired
    private ITservicioTest servicioTest;

    @PostMapping("/enviar")
    public ResponseEntity<?> registrarIngresoTest(@RequestBody TestsEmocionalesDto dto) {
    try {
        // 1. Ejecutamos la lógica y capturamos el objeto guardado con su ID único
        Test_emocional testGuardado = servicioTest.registrarTestEmocional(dto);

        System.out.println("Test creado en BD con ID: " + testGuardado.getIdTest());
        
        // 2. Retornamos el objeto completo con estado 201 (CREATED)
        return ResponseEntity.status(HttpStatus.CREATED).body(testGuardado);
        
    } catch (IllegalArgumentException e) {
        // Captura errores de validación
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    } catch (RuntimeException e) {
        // Captura el caso de que el usuario no exista
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
        // Cualquier otro error inesperado
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno al registrar el test: " + e.getMessage());
        }
    }
}