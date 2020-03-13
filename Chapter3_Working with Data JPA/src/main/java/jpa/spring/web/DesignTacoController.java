package jpa.spring.web;

import jdk.nashorn.internal.codegen.types.Type;
import jpa.spring.Ingredient;
import jpa.spring.Order;
import jpa.spring.Taco;
import jpa.spring.data.IngredientRepository;
import jpa.spring.data.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 13 / 03 / 2020 - 5:02 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */

//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]
@Controller
@RequestMapping("/design")
//end::injectingIngredientRepository[]
@SessionAttributes("order")
//tag::injectingIngredientRepository[]

public class DesignTacoController {
    //
    private final IngredientRepository ingredientRepo;

    //end::injectingIngredientRepository[]
    private TacoRepository tacoRepo;

    //end::injectingDesignRepository[]
  /*
  //tag::injectingIngredientRepository[]
  public DesignTacoController(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  //end::injectingIngredientRepository[]
   */
    //tag::injectingDesignRepository[]

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }

    //end::injectingDesignRepository[]

    //tag::injectingIngredientRepository[]

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Ingredient.Type[] types = Ingredient.Type.values();
//        for (Type type : types) {
//            model.addAttribute(type.toString().toLowerCase(),
//                    filterByType(ingredients, type));
//        }

        return "design";
    }
    //end::injectingIngredientRepository[]

    //tag::injectingDesignRepository[]
    @PostMapping
    public String processDesign(
            @Valid Taco taco, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoRepo.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

//end::injectingDesignRepository[]

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

  /*
  //tag::injectingDesignRepository[]
  //tag::injectingIngredientRepository[]
   ...
  //end::injectingIngredientRepository[]
  //end::injectingDesignRepository[]
  */

//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]

}
//end::injectingIngredientRepository[]
//end::injectingDesignRepository[]