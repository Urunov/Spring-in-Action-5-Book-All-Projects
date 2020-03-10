package spring.boot.data;

import spring.boot.Ingredient;

/**
 * @Created 09 / 03 / 2020 - 5:19 PM
 * @project SpringData
 * @Author Hamdamboy
 */
public interface IngredientRepository {
    //
   Iterable<Ingredient> findAll();

   Ingredient findById(String id);

   Ingredient save(Ingredient ingredient);


}
