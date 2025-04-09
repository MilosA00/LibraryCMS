package com.example.LibraryCMS.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author_table")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_gen")
    @SequenceGenerator(name = "author_id_gen", sequenceName = "author_seq", allocationSize = 1)
    private Long id;

    // Essential identity fields
    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    // Biographical data
    private LocalDate dateOfBirth;

    @Column(name = "biography",length = 2000)
    private String biography;

    // Optional fields for additional info
    @Column(name = "email", unique = true, length = 255, nullable = false)
    private String email;
    @Column(name = "pictureUrl")
    private String profilePictureUrl;
    // Inverse side of the many-to-many relationship
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("authors")
    private Set<Book> books = new HashSet<>();


    public Author() {
    }

    public Author(String firstName, String lastName, LocalDate dateOfBirth, String biography, String email, String profilePictureUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
        this.email = email;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Set<Book> getBooks() {return books;}

    public void setBooks(Set<Book> books) {this.books = books;}
}
