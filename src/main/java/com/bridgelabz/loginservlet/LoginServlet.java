package com.bridgelabz.loginservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    description="Login Servlet testing",
    urlPatterns={ "/LoginServlet" },
    initParams={
            @WebInitParam(name="user", value="Sehaj"),
            @WebInitParam(name= "password", value = "BridgeLabz")
    }
            )
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String userID=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");
        if(userID.equals(user) && password.equals(pwd)){
            request.setAttribute("user", user);
            request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
        }
        else{
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=response.getWriter();
            out.println("<font color= red>Either user name or password is incorrect</font>");
            rd.include(request, response);

        }
    }
    
}
