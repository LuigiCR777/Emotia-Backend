package Emotia.java.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import Emotia.java.clasificadores.ClasificadorDASS;
import Emotia.java.clasificadores.ClasificadorGAD;
import Emotia.java.clasificadores.ClasificadorPHQ;
import Emotia.java.modelo.Resultados;
import Emotia.java.modelo.Test_emocional;
import Emotia.java.repositorio.ITrepositorioResultados;
import Emotia.java.repositorio.ITrespuestas;
import Emotia.java.repositorio.ITrepositorioTestsEmocionales;

@Service
public class servicioResultadosIMPL implements ITservicioResultados {

    @Autowired
    private ITrespuestas respuestasRepo;

    @Autowired
    private ITrepositorioResultados repositorioResultados;

    @Autowired
    private ITrepositorioTestsEmocionales repositorioTest;

    @Autowired
    private ClasificadorPHQ clasificadorPHQ;

    @Autowired
    private ClasificadorGAD clasificadorGAD;

    @Autowired
    private ClasificadorDASS clasificadorDASS;

    @Override
    public Resultados SumaResultados(Long idTest) {

        Integer sumaTotal = respuestasRepo.sumarPuntajePorTest(idTest);

        if (sumaTotal == null) {
            sumaTotal = 0;
        }

        Test_emocional testAsociado = repositorioTest.findById(idTest)
                .orElseThrow(() ->
                        new RuntimeException("No se encontró el test con ID: " + idTest));

        Resultados resultados = new Resultados();

        resultados.setIdtest(testAsociado);
        resultados.setFechaResultado(LocalDate.now());
        resultados.setPuntaje(sumaTotal);

        String tipoTest = testAsociado.getTipoTest();

        switch (tipoTest) {

            case "PHQ-9":
                resultados.setNivelRiesgo(
                        clasificadorPHQ.clasificar(sumaTotal));
                break;

            case "GAD-7":
                resultados.setNivelRiesgo(
                        clasificadorGAD.clasificar(sumaTotal));
                break;

            case "DASS-21":
                // Lo implementaremos cuando hagamos el cálculo de las 3 dimensiones
                resultados.setNivelRiesgo("Pendiente");
                break;

            default:
                resultados.setNivelRiesgo("No clasificado");
                break;
        }

        return repositorioResultados.save(resultados);
    }
}