package Emotia.java.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emotia.java.dto.TecnicaDTO;
import Emotia.java.modelo.Tecnica;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioTecnica;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioTecnicaIMPL implements ITservicioTecnica{

    @Autowired
    ITrepositorioUsuario usuarios;

    @Autowired
    ITrepositorioTecnica tecnicas;

    @Override
    public Tecnica tecnica(TecnicaDTO dto) {
        
        Usuarios id = usuarios.findById(dto.getId_usuario()).orElse(null);

        Tecnica T = new Tecnica();
        T.setIdUsuarios(id);
        T.setFecha_ejercicio(dto.getFecha_ejercicio());
        T.setVistas(dto.getVistas());
        T.setTocadas(dto.getTocadas());
        T.setEscuchadas(dto.getEscuchadas());
        T.setOlidas(dto.getOlidas());
        T.setSaboreadas(dto.getSaboreadas());

        return tecnicas.save(T);

    }

}
