package com.service;

import com.entity.Book;
import com.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface User {

    List<Book> getAll(String name, String author, String language, String thumbnailImage, Integer price);

    List<Book> getSortedBooks(String sortBy, String sortMethod);

    List<Book> searchBooks(String name, String author);
}
