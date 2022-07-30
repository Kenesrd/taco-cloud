package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

}
