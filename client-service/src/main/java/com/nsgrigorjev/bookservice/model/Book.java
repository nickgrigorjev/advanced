package com.nsgrigorjev.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Book {
    private String id;
    private String title;
    private String description;
    private String imageLink;
}
