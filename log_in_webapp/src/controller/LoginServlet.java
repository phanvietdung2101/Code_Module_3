package controller;

import service.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String userpass = request.getParameter("password");

        RequestDispatcher dispatcher ;

        if(LoginDao.validate(username, userpass)){
            dispatcher = request.getRequestDispatcher("login/login_success.jsp");
            dispatcher.forward(request,response);
            HttpSession session = request.getSession();
            session.setAttribute("username","Test test");
        }
        else {
            String login_fail_msg = "Username and password wrong";
            request.setAttribute("msg",login_fail_msg);
            dispatcher = request.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/login_success.jsp");
            dispatcher.forward(request,response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
