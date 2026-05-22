package Emotia.java.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table (name = "otp_codes")
@Entity
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_otp")
    private int Idotp;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios Idusuario;
    private String codigo;
    @Column (name = "fecha_generado")
    private LocalDateTime fechaGenerado;
    @Column (name = "valido_hasta")
    private LocalDateTime validoHasta;
    private String estado;

    public int getIdotp() {
        return Idotp;
    }
    public void setIdotp(int idotp) {
        Idotp = idotp;
    }
    public Usuarios getIdusuario() {
        return Idusuario;
    }
    public void setIdusuario(Usuarios idusuario) {
        Idusuario = idusuario;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public LocalDateTime getFechaGenerado() {
        return fechaGenerado;
    }
    public void setFechaGenerado(LocalDateTime fechaGenerado) {
        this.fechaGenerado = fechaGenerado;
    }
    public LocalDateTime getValidoHasta() {
        return validoHasta;
    }
    public void setValidoHasta(LocalDateTime validoHasta) {
        this.validoHasta = validoHasta;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Otp() {
    }
    public Otp(int idotp, Usuarios idusuario, String codigo, LocalDateTime fechaGenerado, LocalDateTime validoHasta,
            String estado) {
        Idotp = idotp;
        Idusuario = idusuario;
        this.codigo = codigo;
        this.fechaGenerado = fechaGenerado;
        this.validoHasta = validoHasta;
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Idotp;
        result = prime * result + ((Idusuario == null) ? 0 : Idusuario.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((fechaGenerado == null) ? 0 : fechaGenerado.hashCode());
        result = prime * result + ((validoHasta == null) ? 0 : validoHasta.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
        Otp other = (Otp) obj;
        if (Idotp != other.Idotp)
            return false;
        if (Idusuario == null) {
            if (other.Idusuario != null)
                return false;
        } else if (!Idusuario.equals(other.Idusuario))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (fechaGenerado == null) {
            if (other.fechaGenerado != null)
                return false;
        } else if (!fechaGenerado.equals(other.fechaGenerado))
            return false;
        if (validoHasta == null) {
            if (other.validoHasta != null)
                return false;
        } else if (!validoHasta.equals(other.validoHasta))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Otp [Idotp=" + Idotp + ", Idusuario=" + Idusuario + ", codigo=" + codigo + ", fechaGenerado="
                + fechaGenerado + ", validoHasta=" + validoHasta + ", estado=" + estado + "]";
    }

    
    

    

}
