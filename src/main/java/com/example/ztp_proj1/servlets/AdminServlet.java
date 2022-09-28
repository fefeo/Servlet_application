package com.example.ztp_proj1.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.ztp_proj1.book.Book;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String year = request.getParameter("year");
        String titleDelete = request.getParameter("titleDelete");
        String authorDelete = request.getParameter("authorDelete");
        String id = request.getParameter("id");
        List<Book> currList = (ArrayList<Book>) getServletContext().getAttribute("books");
        System.out.println(title+author+ year);
        System.out.println("delete");
        System.out.println(titleDelete+authorDelete+id);

        if(title != null && author != null && year != null &&
           title != "" && author != "" && year != "") {
            Book newBook = new Book(title, author, Integer.parseInt(year));
            currList.add(newBook);
        }
        else if(id != null && id != ""){
            for(Book book: currList){
                if(Integer.parseInt(id) == currList.indexOf(book)){
                    currList.remove(book);
                    break;
                }
            }
        }
        RequestDispatcher bookDispatcher = request.getRequestDispatcher("/DashboardServlet");
        bookDispatcher.forward(request, response);
    }
}
