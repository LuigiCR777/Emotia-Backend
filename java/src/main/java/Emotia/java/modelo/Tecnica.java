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
@Table(name = "tecnica_54321")
public class Tecnica {
    @Id
    @Column(name = "id_tecnica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tecnica;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios idUsuarios;

    private LocalDateTime fecha_ejercicio;

    private String vistas;

    private String tocadas;

    private String escuchadas;

    private String olidas;

    private String saboreadas;

    public Tecnica() {
    }

    public Tecnica(Long id_tecnica, Usuarios idUsuarios, LocalDateTime fecha_ejercicio, String vistas, String tocadas,
            String escuchadas, String olidas, String saboreadas) {
        this.id_tecnica = id_tecnica;
        this.idUsuarios = idUsuarios;
        this.fecha_ejercicio = fecha_ejercicio;
        this.vistas = vistas;
        this.tocadas = tocadas;
        this.escuchadas = escuchadas;
        this.olidas = olidas;
        this.saboreadas = saboreadas;
    }

    public Long getId_tecnica() {
        return id_tecnica;
    }

    public void setId_tecnica(Long id_tecnica) {
        this.id_tecnica = id_tecnica;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
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
