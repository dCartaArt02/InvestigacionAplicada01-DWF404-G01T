package com.letrasvivas.bookapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



// Esto le dice a Spring que esta clase será una tabla en la base de datos
@Entity
public class Book {

    @Id  // le decimos que ese campo sera una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // se autogenera el valor de id
    private Long id;

    private String title;
    private String author;
    private int publicationYear;

    // Constructors
    public Book() {}

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
