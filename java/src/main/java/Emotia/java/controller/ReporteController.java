package Emotia.java.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.http.HttpHeaders;
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

    @GetMapping("/reporte")
    public ResponseEntity<byte[]> generarReporte(
            @RequestParam(name = "User") Long user) throws Exception {

        InputStream reporte = getClass()
                .getResourceAsStream("/reports/Reporte.jasper");

        if (reporte == null) {
            throw new RuntimeException(
                    "No se encontró el archivo /reports/Reporte.jasper"
            );
        }

        Map<String, Object> parametros = new HashMap<>();

        // Debe llamarse exactamente igual al parámetro de Jasper
        parametros.put("User", user);

        try (
                InputStream reporteStream = reporte;
                Connection conexion = dataSource.getConnection()
        ) {

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    reporteStream,
                    parametros,
                    conexion
            );

            byte[] pdf = JasperExportManager
                    .exportReportToPdf(jasperPrint);

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "inline; filename=reporte_usuario_" + user + ".pdf"
                    )
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdf.length)
                    .body(pdf);
        }
    }
}

