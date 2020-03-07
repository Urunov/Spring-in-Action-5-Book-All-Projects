package controller;

import model.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import view.Ingredient;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static sun.java2d.cmm.ColorTransform.In;

@Controller
@RequestMapping("/design")

public class DesignTacoController {
    //
    private static final Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("Flto", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.VEGGIES),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce" ,Ingredient.Type.CHEESE),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterry", Ingredient.Type.SAUCE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCS", "Souc Cream", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), ingredients.stream()
            .filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList()));
        }
        model.addAttribute("design", new Taco());

        return "design";

    }

    @PostMapping
    public String processDesing(@Valid Taco design, Errors errors) {
        if(errors.hasErrors()) {
            return "design";
        }
        /*
        * Save toco design, We should to this in Chapter 3, log.info("Processing design:" + design);
        *
        * */

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

}
