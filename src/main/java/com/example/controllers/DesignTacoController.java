package com.example.controllers;

import com.example.entities.Ingredient;
import com.example.entities.Taco;
import com.example.entities.TacoOrder;
import com.example.entities.Type;
import com.example.service.IngredientService;
import com.example.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private IngredientService ingredientService;
    private TacoService tacoService;

    @Autowired
    public DesignTacoController(IngredientService ingredientService, TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }


    @ModelAttribute
    public void addIngredients(Model model){
       Iterable<Ingredient> ingredients = ingredientService.findAll();
        Type[] types = Type.values();

        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
        }
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')", "hasRole('USER')")
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder){

        if (errors.hasErrors()){
            return "design";
        }
        Taco savedTaco = tacoService.saveTaco(taco);
        tacoOrder.addTaco(savedTaco);
        log.info("Processing taco: {}", taco);

        System.out.println("----------------ORDER" + tacoOrder);

        return "redirect:/orders/current";
    }
}
