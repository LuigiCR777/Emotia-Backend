package Emotia.java.modelo;

import java.util.Date;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuarios")

public class Usuarios {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long Idusuarios;

    private String nombre;

    private String apellido;

    private String telefono;

    private String correo;

    private Date nacimiento;

    private String pais;
    
    @Column (name = "fecha_registro")
    private Date fechaGenerado;

    
    public Usuarios(String correo, Date nacimiento, String pais, Date fechaGenerado) {
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.pais = pais;
        this.fechaGenerado = fechaGenerado;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Long getIdusuarios() {
        return Idusuarios;
    }
    public void setIdusuarios(Long idusuarios) {
        Idusuarios = idusuarios;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaGenerado() {
        return fechaGenerado;
    }
    public void setFechaGenerado(Date fechaGenerado) {
        this.fechaGenerado = fechaGenerado;
    }
    public Usuarios(Long idusuarios, String nombre, String apellido, String telefono, Date fechaGenerado) {
        Idusuarios = idusuarios;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaGenerado = fechaGenerado;
    }
    public Usuarios() {
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuarios other = (Usuarios) obj;
        if (Idusuarios != other.Idusuarios)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        if (fechaGenerado == null) {
            if (other.fechaGenerado != null)
                return false;
        } else if (!fechaGenerado.equals(other.fechaGenerado))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Usuarios [Idusuarios=" + Idusuarios + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
                + telefono + ", fechaGenerado=" + fechaGenerado + "]";
    }
    

}
