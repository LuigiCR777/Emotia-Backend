package Emotia.java.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tests_emocionales")
public class Test_emocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long idTest;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios idUsuario;

    @Column(name = "fecha_test")
    private LocalDateTime fechaTest;

    @Column(name = "tipo_test")
    private String tipoTest;

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaTest() {
        return fechaTest;
    }

    public void setFechaTest(LocalDateTime fechaTest) {
        this.fechaTest = fechaTest;
    }

    public String getTipoTest() {
        return tipoTest;
    }

    public void setTipoTest(String tipoTest) {
        this.tipoTest = tipoTest;
    }

}