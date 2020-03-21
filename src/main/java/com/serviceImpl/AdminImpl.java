package com.serviceImpl;

import com.entity.Book;
import com.repository.BookRepo;
import com.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImpl implements Admin {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public void addBooks(List<Book> books) {
        for(Book book : books) {
            bookRepo.insertBook(book.getBookName(),
                    book.getBookAuthor(),
                    book.getBookLanguage(),
                    book.getBookThumbnailImage(),
                    book.getBookPrice());
        }
    }

    @Override
    public void removeBook(String name, String author) {
        bookRepo.removeBook(name, author);
    }
}
