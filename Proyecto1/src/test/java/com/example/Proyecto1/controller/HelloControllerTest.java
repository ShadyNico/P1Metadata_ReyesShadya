package com.example.Proyecto1.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

    @Test
    void saludoEnEspanol() {

        HelloController controller = new HelloController();

        String resultado = controller.home("Shadya", "espanol");

        assertEquals("<h1>¡Hola Shadya!</h1>", resultado);
    }

    @Test
    void saludoEnPortugues() {

        HelloController controller = new HelloController();

        String resultado = controller.home("Shadya", "portugues");

        assertEquals("<h1>¡Olá Shadya!</h1>", resultado);
    }

    @Test
    void saludoEnIngles(){
        HelloController controller = new HelloController();

        String resultado = controller.home("Shadya", "ingles");

        assertEquals("<h1>¡Hello Shadya!</h1>", resultado);
    }
}

