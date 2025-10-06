package com.bookstore.Service;

import com.bookstore.Entity.Book;
import com.bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void save(Book b) {
        bookRepository.save(b);
    }

    public Book getBookById(int id)
    {

        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
