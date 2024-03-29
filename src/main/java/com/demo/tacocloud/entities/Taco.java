package com.demo.tacocloud.entities;

import com.demo.tacocloud.entities.Ingredient;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Taco's name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "Your taco must have at least one ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    private void createdAt() {
        createdAt = new Date();
    }
}
