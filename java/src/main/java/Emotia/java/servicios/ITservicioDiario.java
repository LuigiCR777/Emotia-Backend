package Emotia.java.servicios;

import java.util.List;
import java.util.Set;

import Emotia.java.dto.DiarioDto;
import Emotia.java.modelo.Diario;
import Emotia.java.modelo.Usuarios;

public interface ITservicioDiario {

    public Diario diario (DiarioDto dto);

    public List<Diario> diarios ();
    
    public void eliminar (Long id);
}
