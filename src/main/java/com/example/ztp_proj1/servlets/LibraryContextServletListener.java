package com.example.ztp_proj1.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import com.example.ztp_proj1.book.Book;


@WebListener
public class LibraryContextServletListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    public LibraryContextServletListener() {
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList books = new ArrayList<>();
        Book.FillExampleBooks(books);
        sce.getServletContext().setAttribute("books", books);
    }
}
