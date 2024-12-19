package com.uce.distribuida.rh.app_authors_spring.db;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

}
