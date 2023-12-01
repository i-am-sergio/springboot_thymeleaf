package com.tecsup.ferreteria.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    // @GetMapping("/auth")
    // public String mostrarMiPagina() {
    //     return "auth";
    // }

    @RequestMapping("home")
    public String index(Model model) {
        return "home";
    }
}
