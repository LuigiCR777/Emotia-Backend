package Emotia.java.modelo;

import javax.annotation.processing.Generated;

import org.hibernate.mapping.Column;
import org.hibernate.query.internal.FetchMementoHbmStandard;

import com.google.api.client.util.DateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "ejercicio_respiracion")
public class Ejercicio_respiracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respiracion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios id_usuario;

    private DateTime fecha_ejercicio;

    private int duracion_minutos;

    private int ciclos_realizados;

    public Long getId_respiracion() {
        return id_respiracion;
    }

    public void setId_respiracion(Long id_respiracion) {
        this.id_respiracion = id_respiracion;
    }

    public Usuarios getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuarios id_usuario) {
        this.id_usuario = id_usuario;
    }

    public DateTime getFecha_ejercicio() {
        return fecha_ejercicio;
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

    

}
