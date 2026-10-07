package com.example.Proyecto1.dto;

// DTO: Data Transfer Object, es decir, un objeto para enviar información.
// Este record representa la información
// que nuestro endpoint devolverá al usuario.
public record AppInfoResponse(

        // Nombre de la aplicación
        String name,

        // Versión de la aplicación (sale del pom.xml)
        String version,

        // Descripción de la aplicación
        String description,

        // Ambiente: dev o prod
        String environment,

        // Datos del desarrollador
        DeveloperInfo developer

) {

    // Record anidado para el desarrollador.
    public record DeveloperInfo(String name, String email) {
    }
}
