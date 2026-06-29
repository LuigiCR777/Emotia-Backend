package Emotia.java.servicios;

import Emotia.java.dto.RespuestaTestDTO;
import Emotia.java.modelo.Respuestas_test;
import Emotia.java.modelo.Test_emocional;

public interface ITservicioRespuesta {
    
    public Respuestas_test guardar (RespuestaTestDTO guardar);
    
}
