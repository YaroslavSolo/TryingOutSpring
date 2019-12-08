package com.demo.tacocloud.web;

import com.demo.tacocloud.entities.Taco;
import com.demo.tacocloud.entities.Ingredient;
import com.demo.tacocloud.entities.Ingredient.Type;
import com.demo.tacocloud.services.JdbcIngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import java.util.*;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final JdbcIngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(JdbcIngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors())
            return "design";

        log.info("processing design: " + design);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
