package Emotia.java.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.EjercicioDTO;
import Emotia.java.modelo.Ejercicio_respiracion;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioEjercicio_respiracion;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioEjercicioIMPL implements ITservicioEjercicioRespiracion{

    @Autowired
    ITrepositorioUsuario repositorioUser;

    @Autowired
    ITrepositorioEjercicio_respiracion ejercicios;

    @Override
    public Ejercicio_respiracion respiracion(EjercicioDTO dto) {
        
        Usuarios idUsuarios = repositorioUser.findById(dto.getId_User()).orElse(null);
        
        Ejercicio_respiracion ejercicio = new Ejercicio_respiracion();
        ejercicio.setId_usuario(idUsuarios);
        ejercicio.setFecha_ejercicio(dto.getFecha_ejercicio());
        ejercicio.setDuracion_minutos(dto.getDuracion_minutos());
        ejercicio.setCiclos_realizados(dto.getCiclos_realizados());

        return ejercicios.save(ejercicio);
    }

}
