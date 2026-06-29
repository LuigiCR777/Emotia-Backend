package Emotia.java.dto;

import java.time.LocalDateTime;

public class JuegosDto {

    private Long id_juego;
    private Long id_usuario;
    private LocalDateTime fecha_juego;
    private int puntaje;
    private int emociones_correctas;
    private int emociones_incorrectas;
    private int tiempo_segundos;

    // Constructor vacío
    public JuegosDto() {
    }

    // Constructor con id_juego
    public JuegosDto(Long id_juego) {
        this.id_juego = id_juego;
    }

    // Constructor completo (sin id_juego)
    public JuegosDto(Long id_usuario,
                     LocalDateTime fecha_juego,
                     int puntaje,
                     int emociones_correctas,
                     int emociones_incorrectas,
                     int tiempo_segundos) {

        this.id_usuario = id_usuario;
        this.fecha_juego = fecha_juego;
        this.puntaje = puntaje;
        this.emociones_correctas = emociones_correctas;
        this.emociones_incorrectas = emociones_incorrectas;
        this.tiempo_segundos = tiempo_segundos;
    }

    public Long getId_juego() {
        return id_juego;
    }

    public void setId_juego(Long id_juego) {
        this.id_juego = id_juego;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getFecha_juego() {
        return fecha_juego;
    }

    public void setFecha_juego(LocalDateTime fecha_juego) {
        this.fecha_juego = fecha_juego;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getEmociones_correctas() {
        return emociones_correctas;
    }

    public void setEmociones_correctas(int emociones_correctas) {
        this.emociones_correctas = emociones_correctas;
    }

    public int getEmociones_incorrectas() {
        return emociones_incorrectas;
    }

    public void setEmociones_incorrectas(int emociones_incorrectas) {
        this.emociones_incorrectas = emociones_incorrectas;
    }

    public int getTiempo_segundos() {
        return tiempo_segundos;
    }

    public void setTiempo_segundos(int tiempo_segundos) {
        this.tiempo_segundos = tiempo_segundos;
    }
}