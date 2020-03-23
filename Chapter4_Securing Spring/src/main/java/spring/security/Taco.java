package spring.security;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Created 17 / 03 / 2020 - 6:43 PM
 * @project BootSecure
 * @Author Hamdamboy
 */

@Data
@Entity

public class Taco {
    //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message = "Name be at least 5 characters long")
    private String name;

    private Date createAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createAt(){
        this.createAt = new Date();
    }
}
