package Emotia.java.dto;

import java.util.Map;

public class AnaliticaIARequestDTO {
    private long idRespuesta;
    private Integer timestampVideo;
    private String emocionDetectada;
    private Map<String, Double> probabilidades; // Mapea directo al JSONB de Postgres

    // Getters y Setters
    public long getIdRespuesta() { return idRespuesta; }
    public void setIdRespuesta(long idRespuesta) { this.idRespuesta = idRespuesta; }

    public Integer getTimestampVideo() { return timestampVideo; }
    public void setTimestampVideo(Integer timestampVideo) { this.timestampVideo = timestampVideo; }

    public String getEmocionDetectada() { return emocionDetectada; }
    public void setEmocionDetectada(String emocionDetectada) { this.emocionDetectada = emocionDetectada; }

    public Map<String, Double> getProbabilidades() { return probabilidades; }
    public void setProbabilidades(Map<String, Double> probabilidades) { this.probabilidades = probabilidades; }
}