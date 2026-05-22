package Emotia.java.dto;

public class LogginRequest {
    private String telefono;
    private String codigo;

    public LogginRequest(String telefono, String codigo) {
        this.telefono = telefono;
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LogginRequest() {
    }
    

    
}
