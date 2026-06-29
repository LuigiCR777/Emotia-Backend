package Emotia.java.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Emotia.java.modelo.Respuestas_test;
import Emotia.java.modelo.Test_emocional;


@Repository
public interface ITrespuestas extends JpaRepository <Respuestas_test,Long>{

    @Query("SELECT SUM(r.valrespuesta) FROM Respuestas_test r WHERE r.idtest.idTest = :idTest")
    Integer sumarPuntajePorTest(@Param("idTest") Long idTest);
}
