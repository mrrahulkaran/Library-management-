package com.library.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entities.Book;
import com.library.management.entities.User;
import com.library.management.exception.BookIdNotException;
import com.library.management.repository.BookRepository;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(() ->new BookIdNotException("Book id is incorrect"));
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    public Book updateBook(Long id,Book books) {
		Book existingbook=bookRepo.findById(books.getId()).orElse(null);
		existingbook.setTitle(books.getTitle());
		existingbook.setAuthor(books.getAuthor());
		existingbook.setBorrowedBy(books.getBorrowedBy());
		return existingbook;
    }


}
