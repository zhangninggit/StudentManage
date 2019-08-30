package com.dabiao.servlet;

import com.dabiao.domain.Student;
import com.dabiao.dao.StudentDao;
import com.dabiao.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*request.setAttribute("a",1000);

        request.getRequestDispatcher("/add.jsp").forward(request,response);*/

        Student student = new Student();

        int s_id =  Integer.parseInt( request.getParameter("s_id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String radio = request.getParameter("radio");  // 性别
       // String birthday = request.getParameter("birthday");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd");
        Date birthday = null;
        try {
             birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        student.setStudent_id(s_id);
        student.setName(name);
        student.setAge(age);
        student.setSex(radio);
        student.setBirthday(birthday);

        StudentDao studentDao = new StudentDaoImpl();
        try {
            studentDao.add(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/listServlet");
    }
}
