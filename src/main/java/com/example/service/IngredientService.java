package com.example.service;


import com.example.entities.Ingredient;
import com.example.entities.Taco;

public interface IngredientService {
    Iterable<Ingredient> findAll();
}
