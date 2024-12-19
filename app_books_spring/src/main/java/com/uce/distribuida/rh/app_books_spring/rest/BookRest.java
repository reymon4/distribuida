package com.uce.distribuida.rh.app_books_spring.rest;

import com.uce.distribuida.rh.app_books_spring.db.Book;
import com.uce.distribuida.rh.app_books_spring.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookRest {

    @Autowired
    private BookRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        var book = repository.findById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> update(@PathVariable Integer id,@RequestBody Book book) {
        var bookObj = repository.findById(id);
        if (bookObj == null) {
            return ResponseEntity.notFound().build();
        }
        book.setId(bookObj.getId());
        repository.update(book);
        return ResponseEntity.ok(book);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        var book = repository.findById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(book);
        return ResponseEntity.ok("Deleted book with id: " + id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> create(@RequestBody Book book) {
        repository.save(book);
        return ResponseEntity.ok(book);
    }

}
