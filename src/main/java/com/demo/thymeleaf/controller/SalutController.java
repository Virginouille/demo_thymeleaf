package com.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalutController {

    @GetMapping("/")
    public String salut() {
        return "index";
    }
}
