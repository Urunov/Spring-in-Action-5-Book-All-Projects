// tag::all[]
// tag::allButValidation[]
package spring.boot;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Created 09 / 03 / 2020 - 10:57 AM
 * @project SpringAction
 * @Author Hamdamboy
 */

    /**
     * @Data - annotation at the class level is provided by Lombok
     *
     *
     * **/
    //tag::newFields[]
@Data
public class Taco {
    //
    //end:: allButValidation[]

    private Long id;

    private Date createAt;

    //end::newFields[]
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    //tag::allButValidation[]
    private String name;
    //end::allButValidation[]
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    //tag::allButValidation[]
    private List<String> ingredients;

     /*
//tag::newFields[]
   ...

//end::newFields[]
   */
//tag::newFields[]
}
//end::newFields[]