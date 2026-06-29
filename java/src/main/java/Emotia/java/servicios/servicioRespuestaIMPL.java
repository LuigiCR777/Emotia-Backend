package Emotia.java.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.RespuestaTestDTO;
import Emotia.java.modelo.Respuestas_test;
import Emotia.java.modelo.Test_emocional;
import Emotia.java.repositorio.ITrepositorioTestsEmocionales;
import Emotia.java.repositorio.ITrespuestas;

@Service
public class servicioRespuestaIMPL implements ITservicioRespuesta {

    @Autowired
    private ITrespuestas respuestaRepository;

    @Autowired
    private ITrepositorioTestsEmocionales test;

    @Override
    public Respuestas_test guardar(RespuestaTestDTO dto) {

        Test_emocional emocional =
                test
                .findById(dto.getIdTest())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Test no encontrado: " +
                        dto.getIdTest()
                    )
                );

        Respuestas_test r = new Respuestas_test();
        
        r.setIdtest(emocional);
        r.setNumpregunta(dto.getNumeroPregunta());
        r.setTextotranscrito(dto.getRespuestaTexto());
        r.setValrespuesta(dto.getPuntaje());

        return respuestaRepository.save(r);
    }

}