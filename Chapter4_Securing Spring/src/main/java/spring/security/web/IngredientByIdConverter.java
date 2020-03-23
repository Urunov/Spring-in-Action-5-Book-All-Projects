package spring.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import spring.security.Ingredient;
import spring.security.data.IngredientRepository;

import java.util.Optional;

/**
 * @Created 17 / 03 / 2020 - 6:44 PM
 * @project BootSecure
 * @Author Hamdamboy
 */

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;
    @Autowired
    private IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepo = ingredientRepository;
    }
    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.isPresent() ?
                optionalIngredient.get() : null;
    }
}
