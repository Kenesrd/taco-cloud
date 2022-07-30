package com.example.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(message = "Name must be at least 3 characters long", min = 3)
    private String name;

    @NotNull
    @Size(message = "You must choose at least 1 ingredient", min = 1)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    private Instant createdAt = Instant.now();
}
