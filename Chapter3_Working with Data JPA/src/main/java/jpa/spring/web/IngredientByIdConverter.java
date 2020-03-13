package jpa.spring.web;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import jpa.spring.Ingredient;
import jpa.spring.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Created 13 / 03 / 2020 - 5:02 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.isPresent() ?
                optionalIngredient.get() : null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
