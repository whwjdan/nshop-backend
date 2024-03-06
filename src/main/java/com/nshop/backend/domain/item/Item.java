package com.nshop.backend.domain.item;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "items")
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}
