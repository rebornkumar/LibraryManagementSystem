package com.controller;

import com.entity.Book;
import com.serviceImpl.AdminImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminImpl adminImpl;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HashMap<String,String> addBooks(@RequestBody List<Book> bookList) {
        adminImpl.addBooks(bookList);
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("status","Success");
        return response;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public HashMap<String, String> removeBook(@RequestParam String name, @RequestParam String author) {
        adminImpl.removeBook(name,author);
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("message","Book " + name + " is Deleted");
        response.put("status","Success");
        return response;
    }
}
