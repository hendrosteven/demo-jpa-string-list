package com.kelaskoding.service;

import com.kelaskoding.models.Book;
import com.kelaskoding.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book save(Book book){
        return bookRepo.save(book);
    }

    public Book addTag(Long id, String tag){
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(!optionalBook.isPresent()){
            throw new RuntimeException("Book Id not found");
        }
        Book book = optionalBook.get();
        book.getTags().add(tag);
        return bookRepo.save(book);
    }

    public Iterable<Book> findAll(){
        return bookRepo.findAll();
    }
}
