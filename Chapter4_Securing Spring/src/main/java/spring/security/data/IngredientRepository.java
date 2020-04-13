package spring.security.data;

import org.springframework.data.repository.CrudRepository;
import spring.security.Ingredient;

/**
 * @Created 17 / 03 / 2020 - 6:45 PM
 * @project BootSecure
 * @Author Hamdamboy
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}


