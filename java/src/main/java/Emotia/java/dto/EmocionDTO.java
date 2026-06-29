package Emotia.java.dto;

public class EmocionDTO {

    private Long cantidad;
    private String emocion;

    public EmocionDTO(Long cantidad, String emocion) {
        this.cantidad = cantidad;
        this.emocion = emocion;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public String getEmocion() {
        return emocion;
    }
}