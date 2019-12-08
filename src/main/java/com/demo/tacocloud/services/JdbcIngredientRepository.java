package com.demo.tacocloud.services;

import com.demo.tacocloud.entities.Ingredient;

public interface JdbcIngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
