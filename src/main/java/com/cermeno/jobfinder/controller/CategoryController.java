package com.cermeno.jobfinder.controller;

import com.cermeno.jobfinder.model.Category;
import com.cermeno.jobfinder.service.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Getter
@Setter
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/index")
    public String showIndex(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/listCategories";
    }

    @GetMapping("/create")
    public String create(Category category) {
        return "categories/formCategories";
    }

    /**
     * Saves a new category.
     *
     * @param category category to save.
     * @param bindingResult data binder.
     * @param redirectAttribute flash attribute added to session.
     * @return
     */
    @PostMapping("/save")
    public String save(Category category, BindingResult bindingResult, RedirectAttributes redirectAttribute) {
        if (bindingResult.hasErrors()){
            return "categories/formCategories";
        }

        System.out.println("New category: " + category.toString());
        categoryService.save(category);
        redirectAttribute.addFlashAttribute("message", "Category saved.");
        return "redirect:/category/index";
    }
}