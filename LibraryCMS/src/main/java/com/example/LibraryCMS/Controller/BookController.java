package com.example.LibraryCMS.Controller;

import com.example.LibraryCMS.Model.Book;
import com.example.LibraryCMS.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @ResponseBody
    @GetMapping("/get_books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/add_book")
    public Book addBook(@RequestBody Book book ){
        return bookRepository.save(book);
    }








}
