package Emotia.java.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Emotia.java.modelo.Diario;

public interface ITrepositorioDiario extends JpaRepository<Diario, Long> {

    List<Diario> findByIdUsuarios_IdUsuario(Long idUsuario);
}