package com.bookstore.Repository;

import com.bookstore.Entity.Book;
import com.bookstore.Service.BookService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
}
