package com.uce.distribuida.rh.app_authors_spring.rest;


import com.uce.distribuida.rh.app_authors_spring.db.Author;
import com.uce.distribuida.rh.app_authors_spring.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorRest {

    @Autowired
    private AuthorRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        var author = repository.findById(id);
        System.out.println("Consultando el autor con id: " + id);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> update(@PathVariable Integer id,@RequestBody Author author) {
        var authorObj = repository.findById(id);
        if (authorObj == null) {
            return ResponseEntity.notFound().build();
        }
        author.setId(authorObj.getId());
        repository.update(author);
        return ResponseEntity.ok(author);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        var author = repository.findById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(author);
        return ResponseEntity.ok("Deleted author with id: " + id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> create(@RequestBody Author author) {
        repository.save(author);
        return ResponseEntity.ok(author);
    }
}
