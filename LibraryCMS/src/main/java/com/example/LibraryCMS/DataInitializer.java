package com.example.LibraryCMS;

import com.example.LibraryCMS.Model.Author;
import com.example.LibraryCMS.Model.Book;
import com.example.LibraryCMS.Repository.AuthorRepository;
import com.example.LibraryCMS.Repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Create Authors
        Author author1 = new Author("John", "Doe", LocalDate.of(1980, 1, 1),
                "Bio for John Doe", "john@example.com", "http://example.com/john.jpg");
        Author author2 = new Author("Jane", "Smith", LocalDate.of(1975, 5, 20),
                "Bio for Jane Smith", "jane@example.com", "http://example.com/jane.jpg");
        Author author3 = new Author("Robert", "Martin", LocalDate.of(1952, 12, 5),
                "Famous author in software craftsmanship", "robert@example.com", "http://example.com/robert.jpg");

        // Save authors first so that they get an ID generated
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        // Create Books with associations to authors
        Book book1 = new Book("Effective Java", "9780134685991",
                "A comprehensive guide to best practices in Java programming.",
                LocalDate.of(2018, 1, 6), 412);
        // Associate the first and second author with the book.
        Set<Author> authorsForBook1 = new HashSet<>();
        authorsForBook1.add(author1);
        authorsForBook1.add(author2);
        book1.setAuthors(authorsForBook1);
        bookRepository.save(book1);

        Book book2 = new Book("Clean Code", "9780132350884",
                "A Handbook of Agile Software Craftsmanship.",
                LocalDate.of(2008, 8, 1), 464);
        // Associate with a single author.
        Set<Author> authorsForBook2 = new HashSet<>();
        authorsForBook2.add(author3);
        book2.setAuthors(authorsForBook2);
        bookRepository.save(book2);

        Book book3 = new Book("Spring in Action", "9781617294945",
                "Practical advice and best practices for the Spring framework.",
                LocalDate.of(2018, 9, 25), 520);
        // Associate with multiple authors, reusing existing ones.
        Set<Author> authorsForBook3 = new HashSet<>();
        authorsForBook3.add(author1);
        authorsForBook3.add(author3);
        book3.setAuthors(authorsForBook3);
        bookRepository.save(book3);

        System.out.println("Data initialization complete.");
    }
}
