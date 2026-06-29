package Emotia.java.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Emotia.java.modelo.Test_emocional;

public interface ITrepositorioTestsEmocionales extends JpaRepository<Test_emocional, Long> {

    Test_emocional findByidTest(Long idTest);
}
