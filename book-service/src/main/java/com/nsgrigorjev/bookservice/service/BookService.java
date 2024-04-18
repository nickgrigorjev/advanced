package com.nsgrigorjev.bookservice.service;

import com.nsgrigorjev.bookservice.repository.BookRepository;
import com.nsgrigorjev.bookservice.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
