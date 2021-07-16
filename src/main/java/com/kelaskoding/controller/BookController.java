package com.kelaskoding.controller;

import com.kelaskoding.dto.Tag;
import com.kelaskoding.models.Book;
import com.kelaskoding.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public Iterable<Book> findAll(){
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public Book addTag(@RequestBody Tag tag, @PathVariable("id") Long id){
        return bookService.addTag(id,tag.getTagName());
    }
}
