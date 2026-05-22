package Emotia.java.modelo;

import java.sql.Date;
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
    private int Idusuarios;
    private String nombre;
    private String apellido;
    private String telefono;
    @Column (name = "fecha_registro")
    private Date fechaGenerado;
    
    public int getIdusuarios() {
        return Idusuarios;
    }
    public void setIdusuarios(int idusuarios) {
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
    public Usuarios(int idusuarios, String nombre, String apellido, String telefono, Date fechaGenerado) {
        Idusuarios = idusuarios;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaGenerado = fechaGenerado;
    }
    public Usuarios() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Idusuarios;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + ((fechaGenerado == null) ? 0 : fechaGenerado.hashCode());
        return result;
    }
    @Override
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
