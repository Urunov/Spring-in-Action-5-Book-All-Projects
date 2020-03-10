package spring.boot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.boot.Ingredient;

import spring.boot.Ingredient.Type;
import spring.boot.Taco;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 09 / 03 / 2020 - 11:31 AM
 * @project SpringAction
 * @Author Hamdamboy
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    //end::head[]

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients =
                Arrays.asList(
                        new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                        new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                        new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                        new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                        new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                        new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                        new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                        new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                        new Ingredient("SLSA", "Salsa", Type.SAUCE),
                        new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredient.Type.values();
        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    //tag::showDesignForm[]
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }
    //end::showDesignForm[]

   /*
    //tag::processDesignValidated[]
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        //Save the taco design.. ..
        // we should do this part in the Chapter 3.
        log.info("Processing design: {}", design );

        return "redirect:/orders/current";
    }

    //end::processDesign[]
   */

    //tag::processDesignValidated[]
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

//end::processDesignValidated[]

    //tag::filterByType[]
    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }



//end::filterByType[]
// tag::foot[]
}
// end::foot[]