package Emotia.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.modelo.Resultados;
import Emotia.java.repositorio.ITrepositorioResultados;
import Emotia.java.servicios.ITservicioResultados;
import Emotia.java.servicios.servicioAnaliticaIMPL;

@RequestMapping("/api/resultado")
@RestController
@CrossOrigin("*")
public class LastResultController {
    
    @Autowired
    servicioAnaliticaIMPL servicioAnalitica;

    @Autowired
    private ITrepositorioResultados repositorioResultados;

    @Autowired
    private ITservicioResultados servicioResultados;

    // Flutter llama esto al terminar el test → guarda en resultados
    @PostMapping("/calcular/{idTest}")
    public ResponseEntity<?> calcularResultado(@PathVariable Long idTest) {
        try {
            Resultados resultado = servicioResultados.SumaResultados(idTest);

            Map<String, Object> respuesta = new HashMap<>();
                respuesta.put("resultado", resultado.getPuntaje());
                respuesta.put("nivel_riesgo",
                        resultado.getNivelRiesgo() != null
                                ? resultado.getNivelRiesgo()
                                : "Pendiente");
                respuesta.put("recomendaciones", resultado.getRecomendaciones());

                return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    // Flutter llama esto en la pantalla de progreso → devuelve los 3 tests
    @GetMapping("/resumen")
    public ResponseEntity<?> obtenerResumenPorUsuario() {
        try {
            List<String> tipos = List.of("PHQ-9", "GAD-7", "DASS-21");
            List<Map<String, Object>> resumen = new ArrayList<>();

            for (String tipo : tipos) {
                List<Resultados> resultados = repositorioResultados.findByTipoTestYUsuario(tipo, 1L);
                Resultados resultado = resultados.isEmpty() ? null : resultados.get(0);

                Map<String, Object> item = new HashMap<>();
                item.put("tipo_test", tipo);

                if (resultado != null) {
                    List<Map<String, Object>> emociones =
                        servicioAnalitica.obtenerConteoEmocionesPorTest(
                            resultado.getIdtest().getIdTest());

                    item.put("puntaje", resultado.getPuntaje());
                    item.put("nivel_riesgo", resultado.getNivelRiesgo());
                    item.put("recomendaciones", resultado.getRecomendaciones());
                    item.put("emociones", emociones);
                    item.put("fecha", resultado.getFechaResultado());
                } else {
                    item.put("puntaje", null);
                    item.put("nivel_riesgo", null);
                    item.put("recomendaciones", null);
                    item.put("emociones", List.of());
                    item.put("fecha", null);
                }

                resumen.add(item);
            }

            return ResponseEntity.ok(resumen);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}