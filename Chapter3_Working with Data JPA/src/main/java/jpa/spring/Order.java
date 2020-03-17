package jpa.spring;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created 13 / 03 / 2020 - 3:49 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */

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

    //end::allButDetailProperties[]
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign (Taco design){
        this.tacos.add(design);
    }

    @PrePersist
        void placeAt () {
        this.placeAt = new Date();
    }
}
//end::allButDetailProperties[]