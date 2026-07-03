package Emotia.java.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import Emotia.java.modelo.Usuarios;

public interface ITrepositorioUsuario extends JpaRepository<Usuarios,Long>{

    Usuarios findByUsuario(String usuario);

    Usuarios findByTelefono(String telefono);

}


