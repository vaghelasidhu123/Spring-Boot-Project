package com.bookstore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Book name is required")
    private String name;

    @NotEmpty(message = "Author is required")
    private String author;

    @NotEmpty(message = "Price is required")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Invalid price format")
    private String price;
}
