package com.example.Proyecto1.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// Indica que Spring debe crear y administrar este objeto.
@Component
// Todas las propiedades que empiecen con "app.info"
// se guardarán en esta clase.
@ConfigurationProperties(prefix = "app.info")
// Pide a Spring que valide los datos al arrancar.
// Si algo no cumple las reglas, la app NO inicia.
@Validated
public class AppInfoProperties {

    // Guardará el nombre de la aplicación.
    @NotBlank
    private String name;

    // Guardará la versión de la aplicación.
    // Viene del pom.xml gracias a @project.version@.
    @NotBlank
    @Pattern(regexp = "\\d+\\.\\d+\\.\\d+(-SNAPSHOT)?",
            message = "la version debe tener formato X.Y.Z")
    private String version;

    // Guardará una pequeña descripción.
    @NotBlank
    private String description;

    // Ambiente en el que corre la app (dev o prod).
    @NotBlank
    private String environment;

    // Datos del desarrollador (app.info.developer.*).
    @Valid
    @NotNull
    private Developer developer = new Developer();


    // Clase interna para agrupar los datos del desarrollador.
    public static class Developer {

        @NotBlank
        private String name;

        @NotBlank
        @Email
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


    // GETTERS
    // Permiten obtener los valores de las variables.

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getEnvironment() {
        return environment;
    }

    public Developer getDeveloper() {
        return developer;
    }


    // SETTERS
    // Spring los utiliza para colocar los valores
    // que vienen desde application.properties.

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
