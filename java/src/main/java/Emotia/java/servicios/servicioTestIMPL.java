package Emotia.java.servicios;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.TestsEmocionalesDto;
import Emotia.java.modelo.Test_emocional;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioTestsEmocionales;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioTestIMPL implements ITservicioTest {

    @Autowired
    private ITrepositorioUsuario repositorioUsuario;

    @Autowired
    private ITrepositorioTestsEmocionales repositorioTest;

    @Override
    public Test_emocional registrarTestEmocional(
        TestsEmocionalesDto dto
    ) {

        if (dto == null) {
            throw new IllegalArgumentException(
                "El DTO no puede ser nulo"
            );
        }

        if (dto.getIdusuario() == null) {
            throw new IllegalArgumentException(
                "El ID del usuario no puede ser nulo"
            );
        }

        System.out.println(
            "ID recibido desde Flutter: " +
            dto.getIdusuario()
        );

        Usuarios usuarioReal = repositorioUsuario
            .findById(dto.getIdusuario())
            .orElseThrow(() ->
                new RuntimeException(
                    "Usuario no encontrado con ID: " +
                    dto.getIdusuario()
                )
            );

        Test_emocional testEntidad = new Test_emocional();

        testEntidad.setIdUsuario(usuarioReal);

        testEntidad.setTipoTest(
            dto.getNombreTest()
        );

        testEntidad.setFechaTest(
            LocalDateTime.now()
        );

        Test_emocional testGuardado =
            repositorioTest.save(testEntidad);

        System.out.println(
            "Test guardado con ID: " +
            testGuardado.getIdTest()
        );

        return testGuardado;
    }

}