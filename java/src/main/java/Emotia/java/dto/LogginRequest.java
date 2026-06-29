package Emotia.java.dto;

public class LogginRequest {
    
    private String telefono;

    public LogginRequest(String telefono, String codigo) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LogginRequest() {
    }
    

    
}
