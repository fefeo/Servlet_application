package com.example.ztp_proj1.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.example.ztp_proj1.User.User;


@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_name = request.getParameter("u_name");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();

        if (u_name.equals(User.Admin().login) && pass.equals(User.Admin().pass)) {
            session.setAttribute("username", u_name);
            session.setAttribute("password", pass);
            session.setAttribute("role",User.Admin().role);
            RequestDispatcher adminDispatcher = request.getRequestDispatcher("/DashboardServlet");
            adminDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("loginFailed.jsp");
        }
    }

}
