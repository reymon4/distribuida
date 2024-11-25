package com.distribuida.rh.db;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;

   // @Column(name = "nombre")
    private String nombre;

   // @Column(name = "direccion")
    private String direccion;


}
