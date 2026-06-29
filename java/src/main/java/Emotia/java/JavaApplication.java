package Emotia.java;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Emotia.java.modelo.Test_emocional;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioTestsEmocionales;
import Emotia.java.repositorio.ITrepositorioUsuario;

@SpringBootApplication
public class JavaApplication {

    @Autowired
    ITrepositorioUsuario repositorioUsuario;

    @Autowired
    ITrepositorioTestsEmocionales repositorioTest;

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

   
}