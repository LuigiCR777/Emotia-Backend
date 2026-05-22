package Emotia.java.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Emotia.java.modelo.Usuarios;

public interface ITrepositorioUsuario extends JpaRepository<Usuarios,Integer>{

    Usuarios findByTelefono(String telefono);

    Usuarios findByNombre(String nombre);

}


