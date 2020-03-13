package jpa.spring.data;

import jpa.spring.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @Created 13 / 03 / 2020 - 5:03 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
