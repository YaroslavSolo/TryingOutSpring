package com.demo.tacocloud.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@Data
@Entity
@Table(name = "Taco_Order")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    // It's possible to use @Size(min = 1) instead
    @NotBlank(message = "Should not be blank")
    private String deliveryName;

    @NotBlank(message = "Should not be blank")
    private String deliveryStreet;

    @NotBlank(message = "Should not be blank")
    private String deliveryCity;

    @NotBlank(message = "Should not be blank")
    private String deliveryState;

    @NotBlank(message = "Should not be blank")
    private String deliveryZip;

    @CreditCardNumber(message = "Invalid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9] | 1[0-2]) ([\\/]) ([1-9][0-9]$)", message = "Exp. date must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid cvv")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    @Size(min = 1, message = "Your order must include at least one position")
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        tacos.add(design);
    }

    @PrePersist
    private void placedAt() {
        placedAt = new Date();
    }

}