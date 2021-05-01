package com.cermeno.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @GetMapping("/index")
    public String showIndex(Model model) {
        return "categories/listCategories";
    }

    @GetMapping("/create")
    public String create() {
        return "categories/formCategories";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("description") String description) {
        System.out.println("Category: " + name);
        System.out.println("Description: " + description);
        return "categories/listCategories";
    }
}