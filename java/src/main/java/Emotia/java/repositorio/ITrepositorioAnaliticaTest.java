package Emotia.java.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Emotia.java.modelo.analitica_test;

public interface ITrepositorioAnaliticaTest extends JpaRepository<analitica_test, Long> {

    @Query(value = """
    SELECT COUNT(a.emocion_detectada) AS conteo,
           a.emocion_detectada
    FROM analitica_ia_test a
    JOIN respuestas_test r ON a.id_respuesta = r.id_respuesta
    WHERE r.id_test = :idTest
      AND LOWER(TRIM(a.emocion_detectada)) != 'no detectado'
    GROUP BY a.emocion_detectada
    ORDER BY conteo DESC
    """, nativeQuery = true)
List<Object[]> obtenerConteoEmocionesPorTest(@Param("idTest") Long idTest);

}