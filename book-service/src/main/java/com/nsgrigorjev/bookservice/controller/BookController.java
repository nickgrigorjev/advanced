package com.nsgrigorjev.bookservice.controller;

import com.nsgrigorjev.bookservice.model.Book;
import com.nsgrigorjev.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book")
    public Book getFirstBook() {
        return Book.builder()
                .id("first")
                .title("Горе от ума")
                .description("Описание")
                .imageLink("https://google.com")
                .build();
    }
}
