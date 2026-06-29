package Emotia.java.dto;

public class TestsEmocionalesDto {

    private Long idTest;
    private Long idusuario;
    private String nombreTest;

    public TestsEmocionalesDto(Long idTest, Long idusuario, String nombreTest) {
        this.idTest = idTest;
        this.idusuario = idusuario;
        this.nombreTest = nombreTest;
    }

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreTest() {
        return nombreTest;
    }

    public void setNombreTest(String nombreTest) {
        this.nombreTest = nombreTest;
    }

    

}
    