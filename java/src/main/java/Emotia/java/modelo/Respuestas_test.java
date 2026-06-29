package Emotia.java.modelo;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuestas_test")
public class Respuestas_test {
    @Id
    @Column(name = "id_respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuesta;

    @ManyToOne
    @JoinColumn(name = "id_test", referencedColumnName = "id_test")
    private Test_emocional idtest;

    @Column(name = "num_pregunta")
    private int numpregunta;
    
    @Column(name = "valor_respuesta")
    private int valrespuesta;

    @Column(name = "texto_transcrito")
    private String textotranscrito;

    @Column(name = "emocion_fer_predominante")
    private String EmocionPre;

    @Column(name = "confianza_fer")
    private double ConfianzaFer;

    public Long getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(Long id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public Test_emocional getIdtest() {
        return idtest;
    }

    public void setIdtest(Test_emocional idtest) {
        this.idtest = idtest;
    }

    public int getNumpregunta() {
        return numpregunta;
    }

    public void setNumpregunta(int numpregunta) {
        this.numpregunta = numpregunta;
    }

    public int getValrespuesta() {
        return valrespuesta;
    }

    public void setValrespuesta(int valrespuesta) {
        this.valrespuesta = valrespuesta;
    }

    public String getTextotranscrito() {
        return textotranscrito;
    }

    public void setTextotranscrito(String textotranscrito) {
        this.textotranscrito = textotranscrito;
    }

    public String getEmocionPre() {
        return EmocionPre;
    }

    public void setEmocionPre(String emocionPre) {
        EmocionPre = emocionPre;
    }

    public double getConfianzaFer() {
        return ConfianzaFer;
    }

    public void setConfianzaFer(double confianzaFer) {
        ConfianzaFer = confianzaFer;
    }

    

}
