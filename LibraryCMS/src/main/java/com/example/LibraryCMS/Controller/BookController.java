package com.example.LibraryCMS.Controller;

import com.example.LibraryCMS.Model.Book;
import com.example.LibraryCMS.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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


    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/remove_book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){

        if(!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/edit_book")
    public Book editBook(@RequestBody Book book){

        Book temp = bookRepository.getReferenceById(book.getId());

        if(book.getId() != null){

            if(book.getTitle() != null) {
                temp.setTitle(book.getTitle());
            }
            if(book.getSummary() != null) {
                temp.setSummary(book.getSummary());
            }
            if(book.getPageCount() != null) {
                temp.setPageCount(book.getPageCount());
            }
            return bookRepository.save(temp);
        }
        return bookRepository.findById(book.getId()).get();
    }


}
