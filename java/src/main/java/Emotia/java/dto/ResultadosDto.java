package Emotia.java.dto;

public class ResultadosDto {

    private Long id_resultado;

    private String nivel_riesgo;

    private String recomendaciones;

    private int resultado;

    public ResultadosDto() {
    }

    public ResultadosDto(Long id_resultado, String nivel_riesgo, String recomendaciones, int resultado) {
        this.id_resultado = id_resultado;
        this.nivel_riesgo = nivel_riesgo;
        this.recomendaciones = recomendaciones;
        this.resultado = resultado;
    }

    public Long getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(Long id_resultado) {
        this.id_resultado = id_resultado;
    }

    public String getNivel_riesgo() {
        return nivel_riesgo;
    }

    public void setNivel_riesgo(String nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    

}
