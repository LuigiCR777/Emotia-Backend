package Emotia.java.dto;

import java.time.LocalDateTime;

public class DiarioDto {

    private LocalDateTime fecha;

    private String titulo;

    private String contenido;

    private String estado;

    private Long idUsuario;

    

    public DiarioDto() {
    }

    public DiarioDto(LocalDateTime fecha, String titulo, String contenido, String estado, Long idUsuario) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    

    

}   
