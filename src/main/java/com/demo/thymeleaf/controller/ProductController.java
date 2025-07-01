package com.demo.thymeleaf.controller;

import com.demo.thymeleaf.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    //Instancier nos produits en mémoire
    private final List<Product> products = new ArrayList<>(
        List.of(
            new Product(1L, "product 1",new BigDecimal("10.00")),
            new Product(2L, "product 2", new BigDecimal("20.00")),
            new Product(3L, "product 3", new BigDecimal("30.00"))
            )
        );

        private Long counter = (long) products.size();

        @GetMapping("/products")
    public String products(Model model) {
            model.addAttribute("productlist", products);
            return "products";
        }

        @GetMapping("/products/add")
    public String addProduct(Model model) {
            model.addAttribute("product", new Product());
            return "add-product";
        }

        @PostMapping("/products/add")
    public String addProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {

            //Si j'ai des erreurs je reste sur la page d'ajout
            if (result.hasErrors()) {
                return "add-product";
            }
            products.add(product);
            return "redirect:/products";
        }
}
