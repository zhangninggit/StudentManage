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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();

        int id =  Integer.parseInt( request.getParameter("id")); // 主键id
        int s_id =  Integer.parseInt( request.getParameter("s_id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String radio = request.getParameter("radio");  // 性别 radio是Jsp中的一个标签名 代表性别 可以选择男女
        // String birthday = request.getParameter("birthday");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setId(id);
        student.setStudent_id(s_id);
        student.setName(name);
        student.setAge(age);
        student.setSex(radio);
        student.setBirthday(birthday);

        StudentDao studentDao = new StudentDaoImpl();

        studentDao.update(student);


        String contextPath = request.getContextPath(); // 获取项目名 解决部署到服务器中使用重定向操作时无法获取完整路径名 导致的404问题

        System.out.println(contextPath);
        response.sendRedirect(contextPath+"/listServlet");
    }
}
