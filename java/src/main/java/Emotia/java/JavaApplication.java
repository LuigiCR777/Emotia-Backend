package Emotia.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioUsuario;

@SpringBootApplication
public class JavaApplication {

	@Autowired
	ITrepositorioUsuario repositorioUsuario;

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		
	}

	
    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            List<Usuarios> usuarios = repositorioUsuario.findAll();
            usuarios.forEach(u -> System.out.println(u));
        };
    }

}
