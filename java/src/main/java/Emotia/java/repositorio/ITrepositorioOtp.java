package Emotia.java.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Emotia.java.modelo.Otp;
import Emotia.java.modelo.Usuarios;

public interface ITrepositorioOtp extends JpaRepository<Otp,Integer>{

    //Usuarios save(Usuarios usuario, Otp otp);

    Otp findByCodigo(String codigo);

}
