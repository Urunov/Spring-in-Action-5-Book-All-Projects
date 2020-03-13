package spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.boot.Ingredient;
import spring.boot.Order;
import spring.boot.Taco;
import spring.boot.data.IngredientRepository;
import spring.boot.data.TacoRepository;

import javax.validation.Valid;
//import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 09 / 03 / 2020 - 5:18 PM
 * @project SpringData
 * @Author Hamdamboy
 */

//tag::classShell[]
    @Controller
    @RequestMapping("/design")
    @SessionAttributes("order")

public class DesignTacoController {

    //end::classShell[]

    //tag::bothRepositoryProperties[]
    //tag::ingredientRepoProperty[]

    /* There are 2 variables (ingrient repository, and taco repository)
    *  Controller data values depend on both of them.
    * */

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    //end::bothReportProperties[]

    /*
  // tag::ingredientRepoOnlyCtor[]
  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
// end::ingredientRepoOnlyCtor[]
   */

    //tag::bothReportCtor[]

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository,  TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    //end::bothReportCtor;

    //tag::modelAttributes[]
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
        // ModelAttribute annotation consists of create model. Create model based on object (order).
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    //end::modelAttributes[]
    //tag::showDesignForm[]

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i-> ingredients.add(i));

          Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type viewType: types) {
            model.addAttribute(viewType.toString().toLowerCase(), filterByType(ingredients,viewType));
        }

        return "design";
    }
    //end::showDesignForm[]

    //tag::processDesign[]

    @PostMapping
    public String processDesign(
            @Valid Taco design, Errors errors,
            @ModelAttribute Order order
    ) {
        if(errors.hasErrors()){
            return "design";
        }

        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }
    //end::processDesign[]

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type ) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

     /*
//tag::classShell[]
  ...
//end::classShell[]
   */
//tag::classShell[]
}
//end:: classShell[]