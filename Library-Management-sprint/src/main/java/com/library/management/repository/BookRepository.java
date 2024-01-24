package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
