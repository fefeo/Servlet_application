package com.example.ztp_proj1.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.example.ztp_proj1.User.User;
import com.example.ztp_proj1.book.Book;


@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>\n" + " Dostępne pozycje" + "</h1>");
        for(Book book: books){
            out.println("<p>" +"ID: "+ books.indexOf(book) +". "+ book.toString() + "</p>");
        }
        out.println("<br>");
        out.println("</article></body></html>");

        if(User.Admin().role.equals(session.getAttribute("role"))){
            //Dodawanie książek
            out.println("<h1>\n" + " Dodaj książkę " + "</h1>");
            out.println("<p>" + " W celu dodania pozycji podaj:" + "</p>" );
            out.println("<form action = \"AdminServlet\">\n");
            out.println("Tytuł: <input type = 'text' name = \"title\">" + "<br>");
            out.println("Autor: <input type = 'text' name = \"author\">" + "<br>");
            out.println("Rok publikacji: <input type = 'number' name = \"year\">" + "<br>" + "<br>");
            out.println("<input type = submit value = \"dodaj\">\n");
            out.println("</form>");
            //usuwanie książek
            out.println("<h1>\n" + " Usuń książkę " + "</h1>");
            out.println("<p>" + "W celu usunięcia książki podaj ID" + "</p>" );
            out.println("<form action = \"AdminServlet\">\n");
            out.println("ID: <input type = 'number' name = \"id\">" + "<br>" + "<br>");
            out.println("<input type = submit value = \"usuń\">\n");
            out.println("</form> ");
        }
    }
}
