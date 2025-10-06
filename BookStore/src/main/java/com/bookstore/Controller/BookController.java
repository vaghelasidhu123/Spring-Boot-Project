package com.bookstore.Controller;

import com.bookstore.Entity.Book;
import com.bookstore.Entity.MyBookList;
import com.bookstore.Service.BookService;
import com.bookstore.Service.MyBookListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController
{

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(Model model){
        model.addAttribute("book",new Book());
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> listofBook = bookService.getAllBook();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("booklist");
        mav.addObject("book",listofBook);
        return mav;
    }

    @PostMapping("/save")
    public String getMyBooks(@Valid @ModelAttribute Book b, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "bookRegister";
        }
        bookService.save(b);
        return "redirect:/available_books";
    }




    @GetMapping("/my_books")
    public ModelAndView getMyBook(){
        List<MyBookList> listOfBook = myBookListService.getAllBook();
        return new ModelAndView("myBooks","myBook",listOfBook);
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBookList ml = new MyBookList();
        ml.setName(b.getName());
        ml.setAuthor(b.getAuthor());
        ml.setPrice(b.getPrice());
        myBookListService.saveMyBooks(ml);

        return "redirect:/my_books";
    }

    @RequestMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
    @RequestMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "editbook";
    }


    @PostMapping("/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editbook";
        }
        bookService.save(book);
        return "redirect:/available_books";
    }

}
