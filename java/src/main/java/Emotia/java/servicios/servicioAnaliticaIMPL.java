package Emotia.java.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.repositorio.ITrepositorioAnaliticaTest;

@Service
public class servicioAnaliticaIMPL {

    @Autowired
    private ITrepositorioAnaliticaTest repositorio;

    public List<Map<String, Object>> obtenerConteoEmocionesPorTest(Long idTest) {
    List<Object[]> resultados = repositorio.obtenerConteoEmocionesPorTest(idTest);
    List<Map<String, Object>> emociones = new ArrayList<>();

    for (Object[] row : resultados) {
        Map<String, Object> map = new HashMap<>();
        map.put("cantidad", ((Number) row[0]).intValue());
        map.put("emocion", (String) row[1]);
        emociones.add(map);
    }

    return emociones;
    }
}