package Emotia.java.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.JuegosDto;
import Emotia.java.modelo.Juego_emociones;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioUsuario;
import Emotia.java.repositorio.ITrepositoriojuego_emociones;

@Service
public class servicioJuegosIMPL implements ITservicioJuegos{

    @Autowired
    ITrepositoriojuego_emociones repojuegos;

    @Autowired
    ITrepositorioUsuario repousuario;

    @Override
    public Juego_emociones juegubis(JuegosDto dto) {
        
        Usuarios usuario = repousuario.findById(dto.getId_usuario())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Juego_emociones juego = new Juego_emociones();
        juego.setIdUsuarios(usuario);
        juego.setEmociones_correctas(dto.getEmociones_correctas());
        juego.setEmociones_incorrectas(dto.getEmociones_incorrectas());
        juego.setFecha_juego(dto.getFecha_juego());
        juego.setTiempo_segundos(dto.getTiempo_segundos());
        juego.setPuntaje(dto.getPuntaje());

        return repojuegos.save(juego);

    }

}
