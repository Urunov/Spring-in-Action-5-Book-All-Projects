package jpa.spring;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * @Created 13 / 03 / 2020 - 3:49 PM
 * @project SpringJPA
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
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private Date createAt;

    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message= "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createAt() {
        this.createAt = new Date();
    }
}
