package com.example.Proyecto1.controller;

import com.example.Proyecto1.config.AppInfoProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Solo levanta la capa web (el controlador), no toda la aplicación.
@WebMvcTest(InfoController.class)
// @WebMvcTest no carga @Component normales, así que importamos las propiedades.
@Import(AppInfoProperties.class)
class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void devuelve200() throws Exception {
        mockMvc.perform(get("/api/v1/info"))
                .andExpect(status().isOk());
    }

    @Test
    void devuelveEstructuraJson() throws Exception {
        mockMvc.perform(get("/api/v1/info"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Gestor de Inventario"))
                .andExpect(jsonPath("$.version").isNotEmpty())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.environment").value("dev"))
                .andExpect(jsonPath("$.developer.name").isNotEmpty());
    }

    @Test
    void emailDelDeveloperEsValido() throws Exception {
        mockMvc.perform(get("/api/v1/info"))
                .andExpect(jsonPath("$.developer.email",
                        matchesPattern("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")));
    }

    @Test
    void aliasSinVersionTambienResponde() throws Exception {
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk());
    }
}
