package com.example.ztp_proj1.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("username") == null){
            response.sendRedirect("login.jsp");
        }
        else {
            RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("/DashboardServlet");
            dashboardDispatcher.forward(request, response);
        }
    }
}
