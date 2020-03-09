package spring.boot;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;

/**
 * @Created 09 / 03 / 2020 - 11:05 AM
 * @project SpringAction
 * @Author Hamdamboy
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    //

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        //
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
