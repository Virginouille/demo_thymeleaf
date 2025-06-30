package com.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalutController {

    @GetMapping("/")
    public String salut() {
        return "index";
    }

    @GetMapping("/salut")
    public String salutPage(@RequestParam(defaultValue = "Monde") String name, Model model) {
        model.addAttribute("name", name);
        return "salut";
    }
}
