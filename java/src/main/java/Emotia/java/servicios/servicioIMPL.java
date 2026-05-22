package Emotia.java.servicios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import Emotia.java.dto.CompletarPerfilRequest;
import Emotia.java.dto.LogginRequest;
import Emotia.java.dto.OtpREquest;
import Emotia.java.modelo.Otp;
import Emotia.java.modelo.Usuarios;
import Emotia.java.repositorio.ITrepositorioOtp;
import Emotia.java.repositorio.ITrepositorioUsuario;

@Service
public class servicioIMPL implements ITservicio{

    @Autowired
    ITrepositorioUsuario repositorioUsuario;

    @Autowired
    ITrepositorioOtp repositorioOtp;

    /*private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    // ✅ Generar clave secreta en Base32
    public String generarClaveSecreta() {
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }*/
    

    @Override
    public List<Usuarios> listaUsuarios() {
        List<Usuarios> usuarios = repositorioUsuario.findAll();
        return usuarios;
    }


    /*@Override
    public void enviarotp(OtpREquest request) { 
    // buscar usuario por telefono
    Usuarios usuario = repositorioUsuario.findByTelefono(request.getTelefono());
    // si NO existe, crearlo
    if (usuario == null) {
        usuario = new Usuarios();
        usuario.setTelefono(request.getTelefono());
        usuario = repositorioUsuario.save(usuario);
    }
    String codigoOtp = String.valueOf((int)(Math.random() * 900000) + 100000);

    // crear OTP
    Otp otp = new Otp();
    otp.setCodigo(codigoOtp);
    otp.setEstado("PENDIENTE");
    otp.setFechaGenerado(LocalDateTime.now());
    otp.setValidoHasta(LocalDateTime.now().plusDays(30));
    // relacion con usuario
    otp.setIdusuario(usuario);
    // guardar otp
    repositorioOtp.save(otp);
    // mostrar otp
    System.out.println("OTP generado: " + codigoOtp);
}*/


/*@Override
public boolean ValidarOtp(LogginRequest request) {
    // buscar usuario por telefono
    Usuarios usuario = repositorioUsuario.findByTelefono(request.getTelefono());
    // validar usuario
    if (usuario == null) {
        System.out.println("Usuario no encontrado");
        return false;
    }
    // buscar otp
    Otp otp =repositorioOtp.findByCodigo(request.getCodigo());
    // validar otp existente
    if (otp == null) {System.out.println("OTP incorrecto");
    return false;
    }
    // validar expiracion
    if (otp.getValidoHasta().isBefore(LocalDateTime.now())) 
        {System.out.println("OTP expirado");
        return false;
    }
    // validar estado
    if (!"PENDIENTE".equals(otp.getEstado())) {
    System.out.println("OTP ya utilizado");
    return false;
    }
    // marcar como usado
    otp.setEstado("USADO");
    repositorioOtp.save(otp);
    System.out.println("Ingreso correcto");
    return true;
}
*/


    @Override
    public Usuarios completarPerfil(CompletarPerfilRequest request) {

    // buscar usuario por telefono
    Usuarios usuario =repositorioUsuario.findByTelefono(request.getTelefono());

    // validar existencia
    if (usuario == null) {System.out.println("Usuario no encontrado");

    return null;
    }

    // completar datos
    usuario.setNombre(request.getNombre());
    // guardar cambios
    return repositorioUsuario.save(usuario);
    }

}
