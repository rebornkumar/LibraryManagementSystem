package com.controller;

import com.entity.Book;
import com.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserImpl userImpl;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Book> getBooks(@RequestParam String name, @RequestParam String author, @RequestParam String language, @RequestParam String thumbnailImage, @RequestParam Integer price) {
        return userImpl.getAll(name, author, language, thumbnailImage,price);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public List<Book> sortBooks(@RequestParam String sortBy, @RequestParam String sortMethod) {
        return userImpl.getSortedBooks(sortBy, sortMethod);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Book> searchBook(@RequestParam String name, @RequestParam String author) {
        return userImpl.searchBooks(name, author);
    }
}
