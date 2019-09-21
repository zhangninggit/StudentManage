package com.dabiao.servlet;

import com.dabiao.domain.PageBean;
import com.dabiao.domain.Student;
import com.dabiao.dao.StudentDao;
import com.dabiao.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDao studentDao = new StudentDaoImpl();
        int totalCount = studentDao.getTotal();  // 总记录数

        int rows = 10;
        int totalPage = totalCount%rows==0?(totalCount/rows):(totalCount/rows+1); // 一共有多少页
        // int id =  Integer.parseInt(request.getParameter("id"));  // 当前所在分页条的id

        int currentPage; // 当前的页面

        if(request.getParameter("currentPage")==null || "".equals(request.getParameter("currentPage"))){
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }


        if (currentPage > totalPage){
            currentPage = totalPage;
        }


        if(currentPage < 1){
            currentPage = 1;
        }

        List<Student> students = null;

        students = studentDao.findAllPage(currentPage,rows);

        PageBean<Student> pb = new PageBean<Student>();

        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setList(students);
        pb.setRows(rows);
        pb.setTotalPage(totalPage);

        request.setAttribute("pb",pb);
        /*request.setAttribute("students",students);
        request.setAttribute("total",totalCount);
        request.setAttribute("pageTotal",pageTotal);
        request.setAttribute("id",currentPage);
*/

        request.getRequestDispatcher("/listStudent.jsp").forward(request,response);
        return;



        /* StudentDao studentDao = new StudentDaoImpl();
        try {
            List<Student> students = studentDao.findAll();
            int total = studentDao.getTotal();

            request.setAttribute("students",students);
            request.setAttribute("total",total);

            request.getRequestDispatcher("/listStudent.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
