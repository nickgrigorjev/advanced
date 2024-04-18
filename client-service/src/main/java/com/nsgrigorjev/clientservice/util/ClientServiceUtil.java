package com.nsgrigorjev.clientservice.util;

import com.nsgrigorjev.bookservice.model.Book;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;


@FeignClient(name = "book-service",url = "http://localhost:8085/api/books")
@CircuitBreaker(name = "book-service", fallbackMethod = "fallback")
public interface ClientServiceUtil {
    @GetMapping("/")
    List<Book> getAllBooks();

    default List<Book> fallback(Throwable ex){
        Logger log = LogManager.getLogger(ClientServiceUtil.class);
        log.info(ex.getMessage());
        return Collections.emptyList();
    }
}
