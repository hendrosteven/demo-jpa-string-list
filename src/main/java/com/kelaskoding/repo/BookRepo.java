package com.kelaskoding.repo;

import com.kelaskoding.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
    
}
