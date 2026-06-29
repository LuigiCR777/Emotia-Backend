package Emotia.java.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "juego_emociones")
public class Juego_emociones {
    @Id
    @Column(name = "id_juego")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_juego;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios idUsuarios;

    @Column(name = "fecha_juego")
    private LocalDateTime fecha_juego;

    @Column(name = "puntaje")
    private int puntaje;

    @Column(name ="emociones_correctas")
    private int emociones_correctas;

    @Column(name ="emociones_incorrectas")
    private int emociones_incorrectas;

    @Column(name = "tiempo_segundos")
    private int tiempo_segundos;

    public Long getId_juego() {
        return id_juego;
    }

    public void setId_juego(Long id_juego) {
        this.id_juego = id_juego;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
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

    public Juego_emociones() {
    }

    public Juego_emociones(Long id_juego, Usuarios idUsuarios, LocalDateTime fecha_juego, int puntaje,
            int emociones_correctas, int emociones_incorrectas, int tiempo_segundos) {
        this.id_juego = id_juego;
        this.idUsuarios = idUsuarios;
        this.fecha_juego = fecha_juego;
        this.puntaje = puntaje;
        this.emociones_correctas = emociones_correctas;
        this.emociones_incorrectas = emociones_incorrectas;
        this.tiempo_segundos = tiempo_segundos;
    }

    

}
