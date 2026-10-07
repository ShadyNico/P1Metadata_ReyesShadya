package com.example.Proyecto1.controller;

import com.example.Proyecto1.config.AppInfoProperties;
import com.example.Proyecto1.dto.AppInfoResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Indica que esta clase recibe peticiones HTTP.
@RestController

// Rutas del controlador.
// "/api/v1/info" es la ruta versionada (versión 1 de la API).
// "/api/info" se deja como alias porque es la que pide el enunciado.
@RequestMapping({"/api/v1/info", "/api/info"})
public class InfoController {

    // Aquí guardamos las propiedades de nuestra aplicación.
    private final AppInfoProperties appInfo;


    // Constructor.
    // Spring automáticamente nos entrega
    // el objeto AppInfoProperties.
    public InfoController(AppInfoProperties appInfo) {
        this.appInfo = appInfo;
    }


    // Cuando alguien entre a:
    // http://localhost:8080/api/v1/info
    // se ejecutará este método.
    @GetMapping
    public AppInfoResponse obtenerInformacion() {

        // Creamos un DTO con los datos
        // obtenidos desde application.properties.
        return new AppInfoResponse(
                appInfo.getName(),
                appInfo.getVersion(),
                appInfo.getDescription(),
                appInfo.getEnvironment(),
                new AppInfoResponse.DeveloperInfo(
                        appInfo.getDeveloper().getName(),
                        appInfo.getDeveloper().getEmail()
                )
        );
    }
}
