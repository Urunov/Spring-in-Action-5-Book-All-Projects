package spring.boot;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created 09 / 03 / 2020 - 5:17 PM
 * @project SpringData
 * @Author Hamdamboy
 */

//tag::newFields[]
@RequiredArgsConstructor
@Data

public class Ingredient {
    //

    private final String id;
    private final String name;
    private Type type;


    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}

