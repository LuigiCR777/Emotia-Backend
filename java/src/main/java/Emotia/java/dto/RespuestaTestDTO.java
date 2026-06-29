package Emotia.java.dto;

public class RespuestaTestDTO {

    private Long idTest;
    private Integer numeroPregunta;
    private String textoTranscrito;
    private Integer puntaje;

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Integer getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(Integer numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getRespuestaTexto() {
        return textoTranscrito;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.textoTranscrito = respuestaTexto;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
}
