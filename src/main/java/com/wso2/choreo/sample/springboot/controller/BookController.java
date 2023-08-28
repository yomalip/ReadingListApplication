package com.wso2.choreo.sample.springboot.controller;

import com.wso2.choreo.sample.springboot.model.Book;
import com.wso2.choreo.sample.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @GetMapping
    public Collection<Book> findAllBooks() {
        return service.getBooks().values();
    }

    @GetMapping("{id}")
    public Book findBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
}