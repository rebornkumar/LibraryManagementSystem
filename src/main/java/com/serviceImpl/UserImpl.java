package com.serviceImpl;

import com.entity.Book;
import com.repository.BookRepo;
import com.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements User {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll(String name, String author, String language, String thumbnailImage, Integer price) {
        List<Book> books = new ArrayList<Book>();
        books = bookRepo.getAllBooks(name, author, language, thumbnailImage,price);
        return books;
    }

    @Override
    public List<Book> getSortedBooks(String sortBy, String sortMethod) {
        List<Book> books = new ArrayList<Book>();
        sortBy = sortBy + " " + sortMethod;
        books = bookRepo.getSortedBooks(sortBy);
        return books;
    }

    @Override
    public List<Book> searchBooks(String name, String author) {
        List<Book> books = new ArrayList<Book>();
        books = bookRepo.searchBooks(name,author);
        return books;
    }
}
