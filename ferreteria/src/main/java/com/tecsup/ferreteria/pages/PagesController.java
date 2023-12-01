package com.tecsup.ferreteria.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/login")
    public String mostrarMiPagina() {
        return "auth";
    }
}
