package Emotia.java.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.checkerframework.checker.units.qual.C;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultados {
    @Column(name = "id_resultado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultado;

    @ManyToOne
    @JoinColumn(name = "id_test", referencedColumnName = "id_test")
    private Test_emocional idtest;

    @Column(name = "nivel_riesgo")
    private String nivelRiesgo;

    @Column(name = "recomendaciones")
    private String recomendaciones;

    @Column(name = "fecha_resultado")
    private LocalDate fechaResultado;

    private int puntaje;

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Long getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    public Test_emocional getIdtest() {
        return idtest;
    }

    public void setIdtest(Test_emocional idtest) {
        this.idtest = idtest;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public LocalDate getFechaResultado() {
        return fechaResultado;
    }

    public void setFechaResultado(LocalDate fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    


}
