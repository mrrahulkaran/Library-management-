package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.entities.Book;
import com.library.management.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
	@GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        return new ResponseEntity<Book>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.CREATED); 
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@Valid @PathVariable Long id,@RequestBody Book book){
    	return new ResponseEntity<Book>(bookService.updateBook(id, book),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
    }

    

}
