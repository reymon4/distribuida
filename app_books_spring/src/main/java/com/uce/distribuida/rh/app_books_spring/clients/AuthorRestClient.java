package com.uce.distribuida.rh.app_books_spring.clients;
import org.springframework.cloud.openfeign.FeignClient;
import com.uce.distribuida.rh.app_books_spring.dto.AuthorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "app-authors-spring")
public interface AuthorRestClient {

    @GetMapping("/authors/{id}")
    AuthorDTO findById(@PathVariable("id") Integer id);
}
