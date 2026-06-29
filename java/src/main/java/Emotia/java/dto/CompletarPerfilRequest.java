package Emotia.java.dto;

import java.util.Date;

public class CompletarPerfilRequest {

    private Long id;

    private String nombre;

    private String apellido;

    private String Correo;

    private String telefono;

    private Date Nacimiento;

    private String pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CompletarPerfilRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        Nacimiento = nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public CompletarPerfilRequest(String nombre, String apellido, String correo, String telefono, Date nacimiento,
            String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        Correo = correo;
        this.telefono = telefono;
        Nacimiento = nacimiento;
        this.pais = pais;
    }

    public CompletarPerfilRequest() {
    }

    public Long getId() { return id; }
    
    public void setId(Long id) { this.id = id; }


    
    
    
    
}
