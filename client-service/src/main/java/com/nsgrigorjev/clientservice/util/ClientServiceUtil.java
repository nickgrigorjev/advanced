package com.nsgrigorjev.clientservice.util;

import com.nsgrigorjev.bookservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "clientDemo", url = "http://localhost:8085/api/books")
public interface ClientServiceUtil {
    @GetMapping("/")
    List<Book> getAllBooks();

    @GetMapping("/book")
    Book getFirstBook();
}
