package com.bookstore.Service;

import com.bookstore.Entity.MyBookList;
import com.bookstore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService
{

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList b) {
        myBookRepository.save(b);
    }


    public List<MyBookList> getAllBook() {
       return myBookRepository.findAll();
    }

    public void deleteById(int id)
    {
        myBookRepository.deleteById(id);
    }
}
