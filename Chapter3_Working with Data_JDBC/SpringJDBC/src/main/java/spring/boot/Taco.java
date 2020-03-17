package spring.boot;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;

/**
 * @Created 09 / 03 / 2020 - 5:18 PM
 * @project SpringData
 * @Author Hamdamboy
 */

// tag::newFields
@Data
public class Taco {
    //
    private Long id;

    private Data createAt;

    //end::newFields[]


    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    public void setCreatedAt(Date date) {

    }

    public CallableStatement getCreatedAt() {
        return null;
    }

    /*
//tag::newFields[]
   ...

//end::newFields[]
   */
//tag::newFields[]
}
//end::newFields[]

