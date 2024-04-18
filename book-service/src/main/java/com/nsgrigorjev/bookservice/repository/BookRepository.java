package com.nsgrigorjev.bookservice.repository;

import com.nsgrigorjev.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
