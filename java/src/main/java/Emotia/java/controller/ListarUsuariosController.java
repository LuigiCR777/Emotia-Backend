package Emotia.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Emotia.java.modelo.Usuarios;
import Emotia.java.servicios.ITservicio;

@RestController
@RequestMapping("/api/listar")
@CrossOrigin("*")

public class ListarUsuariosController {

    @Autowired
    ITservicio listar;

    @GetMapping("/usuarios")
    public List<Usuarios> listarusuarios(){

    return listar.listaUsuarios();  
    }

}
