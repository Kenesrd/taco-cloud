package com.example.service;

import com.example.dao.IngredientRepository;
import com.example.entities.Ingredient;
import com.example.entities.Taco;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService{
    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}
