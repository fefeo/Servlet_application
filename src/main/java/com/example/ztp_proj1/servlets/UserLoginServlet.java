package com.example.ztp_proj1.servlets;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.example.ztp_proj1.User.User;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet{
    //Tworzenie HashMapy dla użytkowniku roli USER
    HashMap<String, String> Users = new HashMap<String, String>();

    public void init(){
        //Przykładowi użytkownicy
        List<User> users = Arrays.asList(
            new User("czytelnik11","czyt0077"),
            new User("czytelnik12","czesc1234"),
            new User("czytelnik13","omen991"),
            new User("czytelnik14","Siek1122")
            );
        //HashMap Users
        for(User user : users){
            Users.put(user.login, user.pass);
        }
    }

    //funkcja do sprawdzania poprawności wprowadzonych danych logowania
     boolean checkUser(String login, String pass){
        if(Users.containsKey(login)){
            return pass.equals(Users.get(login));
        }
        else{
            return false;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_name = request.getParameter("u_name");
        String pass = request.getParameter("pass");
        User currentUser = new User(u_name,pass);
        HttpSession session = request.getSession();

        if (checkUser(u_name, pass) == true){
            session.setAttribute("username", u_name);
            session.setAttribute("password", pass);
            session.setAttribute("role", currentUser.role);
            System.out.println(currentUser.role);
            RequestDispatcher adminDispatcher = request.getRequestDispatcher("/DashboardServlet");
            adminDispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("loginFailed.jsp");
        }
    }
}
