package com.dabiao.servlet;

import com.dabiao.dao.impl.StudentDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();



        boolean flag = new StudentDaoImpl().Login(username, password);

        if (flag){
            session.setAttribute("username",username);
            request.getRequestDispatcher("/listServlet").forward(request,response);
        }else {

            request.setAttribute("login_msg","用户名密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            /*String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login.jsp");*/
            return;
        }

    }
}
