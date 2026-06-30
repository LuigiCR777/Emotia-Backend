package Emotia.java.dto;

public class LogginRequest {

    private String telefono;

    public LogginRequest() {
    }

    public LogginRequest(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}