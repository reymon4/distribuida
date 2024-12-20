package com.uce.distribuida.rh.app_books_spring.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {

    private Integer id;

    private String isbn;

    private String tittle;

    private BigDecimal price;

    private String author;
}
