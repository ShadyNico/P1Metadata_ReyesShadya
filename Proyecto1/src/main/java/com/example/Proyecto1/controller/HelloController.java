package com.example.Proyecto1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String home(
            @RequestParam(value = "name", defaultValue = "Mundo") String name,
            @RequestParam(value = "idioma", defaultValue = "espanol") String idioma) {

        switch (idioma.toLowerCase()) {

            case "espanol":
            case "español":
                return String.format("<h1>¡Hola %s!</h1>", name);

            case "ingles":
                return String.format("<h1>¡Hello %s!</h1>", name);

            case "portugues":
                return String.format("<h1>¡Olá %s!</h1>", name);

            // Hebreo Antiguo
            case "hebreo antiguo":
            case "hebreo_antiguo":
                return String.format(
                        "<h1>Shalom Aleikhem, %s! (שָׁלוֹם עֲלֵיכֶם) Que la paz sea contigo.</h1>",
                        name
                );

            case "arameo":
                return String.format(
                        "<h1>Shlama %s! (ܫܠܡܐ)</h1>",
                        name
                );

            case "japones":
                return String.format(
                        "<h1>¡こんにちは、%sさん！ (Konnichiwa, %s-san!)</h1>",
                        name,
                        name
                );

            case "++":
            case "japones_anime":
                return String.format(
                        "<h1>¡Yaho, %s-senpai! ¡El club te está esperando! ✨ (⁄ ⁄>⁄ ▽ ⁄<⁄ ⁄)</h1>",
                        name
                );

            default:
                return """
                        <h1>Idioma no válido</h1>
                        <p>Opciones disponibles:</p>
                        <ul>
                            <li>espanol</li>
                            <li>ingles</li>
                            <li>portugues</li>
                            <li>hebreo_antiguo</li>
                            <li>arameo</li>
                            <li>japones</li>
                            <li>japones_anime</li>
                        </ul>
                        """;
        }
    }
}