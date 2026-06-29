package Emotia.java.modelo;

import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "analitica_ia_test")
public class analitica_test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analitica")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_respuesta")
    private Respuestas_test idrespuesta;

    @Column(name = "timestamp_video")
    private Integer timestampVideo;

    @Column(name = "emocion_detectada")
    private String emociondetectada;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "probabilidades", columnDefinition = "jsonb")

    private Map<String, Double> probabilidades;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Respuestas_test getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(Respuestas_test idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public Integer getTimestampVideo() {
        return timestampVideo;
    }

    public void setTimestampVideo(Integer timestampVideo) {
        this.timestampVideo = timestampVideo;
    }

    public String getEmociondetectada() {
        return emociondetectada;
    }

    public void setEmociondetectada(String emociondetectada) {
        this.emociondetectada = emociondetectada;
    }

    public Map<String, Double> getProbabilidades() {
        return probabilidades;
    }

    public void setProbabilidades(Map<String, Double> probabilidades) {
        this.probabilidades = probabilidades;
    }
    
    
    
    
    

}
