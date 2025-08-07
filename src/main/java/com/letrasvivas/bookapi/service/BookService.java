package com.letrasvivas.bookapi.service;

import com.letrasvivas.bookapi.model.Book;
import com.letrasvivas.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Aqui utilizamos la inyeccion de dependencias en el constructor
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Listamos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // guarda libros
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // busca libros por el titulo
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // borra desde campo id
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
