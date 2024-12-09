package com.programacion.distribuida.books.service.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {

    private Integer id;

    private String isbn;

    private String tittle;

    private BigDecimal price;

    private Integer authorId;
}
