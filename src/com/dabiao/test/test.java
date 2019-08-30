package com.dabiao.test;

import com.dabiao.domain.Student;
import com.dabiao.util.DBUtils;
import com.dabiao.dao.StudentDao;
import com.dabiao.dao.impl.StudentDaoImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class test {

    /**
     * 根据id查学生信息 Student getStudent(int id)
     */
    @Test
    public void test07(){

        Student student = new StudentDaoImpl().getStudent(1);
        System.out.println(student);
    }

    /**
     * 获取总人数getTotal()
     */
    @Test
    public void test06(){
        int i = new StudentDaoImpl().getTotal();
        System.out.println(i);
    }

    /**
     * 测试update(Student student)
     */
    @Test
    public void test05(){

        Student student = new Student(7, 34, "fy", 23,
                "男", new Date());

        new StudentDaoImpl().update(student);

    }


    /**
     * 测试delete(int id)
     */
    @Test
    public void test04(){

        new StudentDaoImpl().delete(2);

    }


    /**
     * 测试添加方法 add(Student student)
     */
    @Test
    public void test03()  {

        Student student = new Student(null, 34, "fy", 23,
                "男", new Date());

        StudentDaoImpl studentAdd = new StudentDaoImpl();
        studentAdd.add(student);

    }

    /**
     * 测试findAll()方法
     */
    @Test
    public void test02() throws SQLException {

        StudentDao students = new StudentDaoImpl();
        List<Student> studentList = students.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    /**
     * 测试DBUtils工具类
     * @throws SQLException
     */
    @Test
    public void test01() throws SQLException {

       /* DataSource dataSource = DBUtils.getDataSource();*/
        Connection conn = DBUtils.getConnection();

        System.out.println(conn);

    }
}
