package Emotia.java.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TecnicaDTO {

    private Long id_usuario;

    private LocalDateTime fecha_ejercicio;

    private String vistas;

    private String tocadas;

    private String escuchadas;
    
    private String olidas;

    private String saboreadas;


    public TecnicaDTO(Long id_usuario, LocalDateTime fecha_ejercicio, String vistas, String tocadas, String escuchadas,
            String olidas, String saboreadas) {
        this.id_usuario = id_usuario;
        this.fecha_ejercicio = fecha_ejercicio;
        this.vistas = vistas;
        this.tocadas = tocadas;
        this.escuchadas = escuchadas;
        this.olidas = olidas;
        this.saboreadas = saboreadas;
    }

    public TecnicaDTO() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getFecha_ejercicio() {
        return fecha_ejercicio;
    }

    public void setFecha_ejercicio(LocalDateTime fecha_ejercicio) {
        this.fecha_ejercicio = fecha_ejercicio;
    }

    public String getVistas() {
        return vistas;
    }

    public void setVistas(String vistas) {
        this.vistas = vistas;
    }

    public String getTocadas() {
        return tocadas;
    }

    public void setTocadas(String tocadas) {
        this.tocadas = tocadas;
    }

    public String getEscuchadas() {
        return escuchadas;
    }

    public void setEscuchadas(String escuchadas) {
        this.escuchadas = escuchadas;
    }

    public String getOlidas() {
        return olidas;
    }

    public void setOlidas(String olidas) {
        this.olidas = olidas;
    }

    public String getSaboreadas() {
        return saboreadas;
    }

    public void setSaboreadas(String saboreadas) {
        this.saboreadas = saboreadas;
    }

    

}
