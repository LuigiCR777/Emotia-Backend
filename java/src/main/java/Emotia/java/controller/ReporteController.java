package Emotia.java.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReporteController {

    private final DataSource dataSource;

    public ReporteController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping(
            value = "/reporte",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public ResponseEntity<?> generarReporte(
            @RequestParam(name = "User") Integer user
    ) {

        try (
                InputStream reporte = getClass()
                        .getResourceAsStream("/reports/Emotia.jasper");

                InputStream logo = getClass()
                        .getResourceAsStream("/reports/logo.png")
        ) {

            if (reporte == null) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(
                                "No se encontró el reporte "
                                + "/reports/Emotia.jasper"
                        );
            }

            if (logo == null) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(
                                "No se encontró el logo "
                                + "/reports/logo.png"
                        );
            }

            Map<String, Object> parametros = new HashMap<>();

            /*
             * Deben coincidir exactamente con los parámetros
             * declarados dentro del reporte Jasper.
             */
            parametros.put("User", user);
            parametros.put("LOGO", logo);

            try (Connection conexion = dataSource.getConnection()) {

                JasperPrint jasperPrint =
                        JasperFillManager.fillReport(
                                reporte,
                                parametros,
                                conexion
                        );

                byte[] pdf =
                        JasperExportManager.exportReportToPdf(
                                jasperPrint
                        );

                return ResponseEntity.ok()
                        .header(
                                HttpHeaders.CONTENT_DISPOSITION,
                                "inline; filename=\"reporte_usuario_"
                                        + user
                                        + ".pdf\""
                        )
                        .contentType(MediaType.APPLICATION_PDF)
                        .contentLength(pdf.length)
                        .body(pdf);
            }

        } catch (Exception error) {

            error.printStackTrace();

            Throwable causa = error;

            while (causa.getCause() != null) {
                causa = causa.getCause();
            }

            String detalle = causa.getMessage();

            if (detalle == null || detalle.isBlank()) {
                detalle = causa.getClass().getName();
            }

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(
                            "Error al generar reporte:\n"
                            + "Tipo: "
                            + causa.getClass().getName()
                            + "\n"
                            + "Detalle: "
                            + detalle
                    );
        }
    }
}