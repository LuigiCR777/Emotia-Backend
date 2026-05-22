package Emotia.java.dto;

public class CompletarPerfilRequest {
    private String telefono;
    private String nombre;
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public CompletarPerfilRequest(String telefono, String nombre) {
        this.telefono = telefono;
        this.nombre = nombre;
    }
    public CompletarPerfilRequest() {
    }

    
}
