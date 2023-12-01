package com.tecsup.ferreteria.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/auth")
    public String mostrarMiPagina() {
        return "auth";
    }
    @RequestMapping("/home")
    public String mainMenu() {
        return "home";
    }
}
