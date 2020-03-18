package spring.security;

/**
 * @Created 17 / 03 / 2020 - 6:43 PM
 * @project BootSecure
 * @Author Hamdamboy
 */

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Data - is the class level is provides by Lombok and tells Lombok to generate all missing methods as well as
 * constructor that accepts all final properties as arguments.
 * **/

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {
    //

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placeAt;

    @ManyToOne
    private User user;

    @NotBlank(message="Delivery name is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "Zip code is required")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placeAt(){
        this.placeAt = new Date();
    }

}
