package Emotia.java.clasificadores;

import org.springframework.stereotype.Component;

@Component
public class ClasificadorGAD {

    public String clasificar(Integer puntaje) {

        if (puntaje == null) {
            return "Sin resultado";
        }

        if (puntaje <= 4) {
            return "Ansiedad mínima";
        } else if (puntaje <= 9) {
            return "Ansiedad leve";
        } else if (puntaje <= 14) {
            return "Ansiedad moderada";
        } else {
            return "Ansiedad grave";
        }

    }

}