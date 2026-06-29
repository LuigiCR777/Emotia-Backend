package Emotia.java.clasificadores;

import org.springframework.stereotype.Component;

@Component
public class ClasificadorDASS {

    public String clasificarDepresion(Integer puntaje) {

        if (puntaje <= 9)
            return "Normal";
        else if (puntaje <= 13)
            return "Leve";
        else if (puntaje <= 20)
            return "Moderada";
        else if (puntaje <= 27)
            return "Severa";
        else
            return "Muy severa";

    }

    public String clasificarAnsiedad(Integer puntaje) {

        if (puntaje <= 7)
            return "Normal";
        else if (puntaje <= 9)
            return "Leve";
        else if (puntaje <= 14)
            return "Moderada";
        else if (puntaje <= 19)
            return "Severa";
        else
            return "Muy severa";

    }

    public String clasificarEstres(Integer puntaje) {

        if (puntaje <= 14)
            return "Normal";
        else if (puntaje <= 18)
            return "Leve";
        else if (puntaje <= 25)
            return "Moderado";
        else if (puntaje <= 33)
            return "Severo";
        else
            return "Muy severo";

    }

}