package com.nshop.backend.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "items")
@Getter
@Entity
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}
