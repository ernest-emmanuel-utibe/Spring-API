package com.example.springapi.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
}
