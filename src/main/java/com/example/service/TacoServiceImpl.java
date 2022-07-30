package com.example.service;

import com.example.dao.TacoRepository;
import com.example.entities.Taco;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService{

    private TacoRepository tacoRepository;

    public TacoServiceImpl(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @Override
    public Taco saveTaco(Taco taco) {
        return tacoRepository.save(taco);
    }
}
