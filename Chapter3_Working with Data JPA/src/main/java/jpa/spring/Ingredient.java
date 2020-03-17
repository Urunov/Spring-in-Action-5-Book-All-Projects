package jpa.spring;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;


/**
 * @Created 13 / 03 / 2020 - 3:49 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

@Entity

public class Ingredient {
    //
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
