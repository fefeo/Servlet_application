package com.example.ztp_proj1.servlets;

import com.example.ztp_proj1.User.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_name = request.getParameter("u_name");
        if(User.Admin().login.equals(u_name))
        {
            RequestDispatcher adminDispatcher = request.getRequestDispatcher("/AdminLoginServlet");
            adminDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher userDispatcher = request.getRequestDispatcher("/UserLoginServlet");
            userDispatcher.forward(request, response);
        }

    }
}

