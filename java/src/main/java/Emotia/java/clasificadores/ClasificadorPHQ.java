package Emotia.java.clasificadores;

import org.springframework.stereotype.Component;

@Component
public class ClasificadorPHQ {

    public String clasificar(Integer puntaje) {

        if (puntaje == null) {
            return "Sin resultado";
        }

        if (puntaje <= 4) {
            return "Depresión mínima o nula";
        } else if (puntaje <= 9) {
            return "Depresión leve";
        } else if (puntaje <= 14) {
            return "Depresión moderada";
        } else if (puntaje <= 19) {
            return "Depresión moderadamente grave";
        } else {
            return "Depresión grave";
        }

    }

}