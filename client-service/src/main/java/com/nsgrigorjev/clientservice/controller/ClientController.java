package com.nsgrigorjev.clientservice.controller;

import com.nsgrigorjev.bookservice.model.Book;
import com.nsgrigorjev.clientservice.util.ClientServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientServiceUtil serviceUtil;
    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return serviceUtil.getAllBooks();
    }


}
