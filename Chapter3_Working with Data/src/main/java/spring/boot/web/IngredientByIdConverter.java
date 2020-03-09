package spring.boot.web;

import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.Ingredient;
import spring.boot.data.IngredientRepository;

/**
 * @Created 09 / 03 / 2020 - 5:18 PM
 * @project SpringData
 * @Author Hamdamboy
 */

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    //
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id);
    }
}
