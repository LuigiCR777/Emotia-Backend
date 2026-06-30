package Emotia.java.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import Emotia.java.modelo.Respuestas_test;
import Emotia.java.modelo.Resultados;

public interface ITrepositorioResultados extends JpaRepository<Resultados, Long> {

    Optional<Resultados> findByIdtest_IdTest(Long idTest);

    Resultados findFirstByOrderByIdResultadoDesc();
    
    @Query("SELECT r FROM Resultados r WHERE r.idtest.tipoTest = :tipoTest AND r.idtest.idUsuario.idUsuario = :idUsuario ORDER BY r.idResultado DESC")
    List<Resultados> findByTipoTestYUsuario(@Param("tipoTest") String tipoTest, @Param("idUsuario") Long idUsuario);
}