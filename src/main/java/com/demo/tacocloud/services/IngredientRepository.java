package com.demo.tacocloud.services;

import org.springframework.data.repository.CrudRepository;
import com.demo.tacocloud.entities.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
