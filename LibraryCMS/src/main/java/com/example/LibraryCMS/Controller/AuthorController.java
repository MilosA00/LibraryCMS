package com.example.LibraryCMS.Controller;


import com.example.LibraryCMS.Model.Author;
import com.example.LibraryCMS.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/author")
@Controller
public class AuthorController {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }





    @RequestMapping("")
    public String placeholder(){
        return "home.html";
    }

    @ResponseBody
    @GetMapping("/get_all")
    public List<Author> authorList(){
        return authorRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/add_author")
    @ResponseBody
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/remove_author/{id}")
    public ResponseEntity<Void> removeAuthor(@PathVariable("id") Long id) {
        if (!authorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        authorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
