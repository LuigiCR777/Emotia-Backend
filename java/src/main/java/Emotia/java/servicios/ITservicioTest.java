package Emotia.java.servicios;

import Emotia.java.dto.TestsEmocionalesDto;
import Emotia.java.modelo.Test_emocional;

public interface ITservicioTest {

    public Test_emocional registrarTestEmocional(TestsEmocionalesDto dto);

    

}
