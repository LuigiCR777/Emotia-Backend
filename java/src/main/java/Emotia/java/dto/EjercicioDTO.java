package Emotia.java.dto;

import java.sql.Time;

import com.google.api.client.util.DateTime;

public class EjercicioDTO {

    private Long id_User;

    private DateTime fecha_ejercicio;

    private int duracion_minutos;

    private int ciclos_realizados;

    public DateTime getFecha_ejercicio() {
        return fecha_ejercicio;
    }

    
    public EjercicioDTO() {
    }

    public EjercicioDTO(DateTime fecha_ejercicio, int duracion_minutos, int ciclos_realizados) {
        this.fecha_ejercicio = fecha_ejercicio;
        this.duracion_minutos = duracion_minutos;
        this.ciclos_realizados = ciclos_realizados;
    }

    public void setFecha_ejercicio(DateTime fecha_ejercicio) {
        this.fecha_ejercicio = fecha_ejercicio;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public int getCiclos_realizados() {
        return ciclos_realizados;
    }

    public void setCiclos_realizados(int ciclos_realizados) {
        this.ciclos_realizados = ciclos_realizados;
    }


    public Long getId_User() {
        return id_User;
    }


    public void setId_User(Long id_User) {
        this.id_User = id_User;
    }


    public EjercicioDTO(Long id_User) {
        this.id_User = id_User;
    }

    
    


}
