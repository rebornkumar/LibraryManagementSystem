package com.service;

import com.entity.Book;
import com.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Admin {

    void addBooks(List<Book>books);

    void removeBook(String name,String author);
}
