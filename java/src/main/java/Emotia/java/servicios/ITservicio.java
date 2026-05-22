package Emotia.java.servicios;

import java.util.List;

import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.dto.LogginRequest;
import Emotia.java.dto.OtpREquest;
import Emotia.java.modelo.Otp;
import Emotia.java.modelo.Usuarios;

public interface ITservicio {

    public List<Usuarios> listaUsuarios();

   /* void enviarotp (OtpREquest request);*/

   /*boolean ValidarOtp (LogginRequest request);*/

    Usuarios completarPerfil(CompletarPerfilRequest request);

}
