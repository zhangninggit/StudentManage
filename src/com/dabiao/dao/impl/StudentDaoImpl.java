package com.dabiao.dao.impl;

import com.dabiao.domain.Student;
import com.dabiao.util.DBUtils;
import com.dabiao.dao.StudentDao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
        Student student = null;
        List<Student> studentList = new ArrayList<>();
        PreparedStatement pstm =null;
        ResultSet resultSet = null;

        Connection conn = null;

        try {
            conn = DBUtils.getConnection();

            String sql = "select * from student";

            pstm = conn.prepareStatement(sql);

            resultSet = pstm.executeQuery();


            while(resultSet.next()){
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setId(resultSet.getInt("id"));
                student.setStudent_id(resultSet.getInt("student_id"));
                student.setSex(resultSet.getString("sex"));
                student.setBirthday(resultSet.getDate("birthday"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtils.close(resultSet,pstm,conn);
        }
        return null;
    }

    @Override
    public List<Student> findAllPage(int currentPage,int rows) {

        Connection conn = null;
        int start = (currentPage - 1)*rows;
        Student student = null;
        List<Student> studentList = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
             conn = DBUtils.getConnection();

             String sql = "select * from student limit ?,?";
              pstm = conn.prepareStatement(sql);
             pstm.setInt(1,start);
             pstm.setInt(2,rows);

              resultSet = pstm.executeQuery();

            studentList = new ArrayList<Student>();
            while(resultSet.next()){
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setId(resultSet.getInt("id"));
                student.setStudent_id(resultSet.getInt("student_id"));
                student.setSex(resultSet.getString("sex"));
                student.setBirthday(resultSet.getDate("birthday"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet,pstm,conn);
        }
        return studentList;


    }

    @Override
    public boolean Login(String username, String password) {


        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtils.getConnection();

            String sql = "select * from USER where username = ? and password = ?";

             pstm = conn.prepareStatement(sql);

             pstm.setString(1,username);
             pstm.setString(2,password);

             resultSet = pstm.executeQuery();
                if(resultSet.next()){
                    flag = true;
                }

            System.out.println("登录状态:"+flag);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet,pstm,conn);
        }

        return flag;

    }

    @Override
    public void add(Student student)  {

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "insert into student values (null,?,?,?,?,?)";


        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,student.getStudent_id());
            pstm.setString(2,student.getName());
            pstm.setInt(3,student.getAge());
            pstm.setString(4,student.getSex());
            pstm.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DBUtils.close(pstm,conn);
        }


    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();

            String sql = "delete from student where id = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,id);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DBUtils.close(pstm,conn);
        }




    }

    @Override
    public void update(Student student) {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
             conn = DBUtils.getConnection();

             String sql = "update student set student_id=?,name=?,age = ?,sex =?,birthday=? where id=?";

             pstm = conn.prepareStatement(sql);

             pstm.setInt(1,student.getStudent_id());
             pstm.setString(2,student.getName());
             pstm.setInt(3,student.getAge());
             pstm.setString(4,student.getSex());
             pstm.setDate(5, new java.sql.Date(student.getBirthday().getTime()));

             pstm.setInt(6,student.getId());


             pstm.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pstm,conn);
        }


    }

    @Override
    public int getTotal() {

        Connection conn = null;
        int count = 0;
        ResultSet resultSet = null;
        PreparedStatement pstm = null;

        try {
             conn = DBUtils.getConnection();

             String sql = "select count(id) from student";

             pstm = conn.prepareStatement(sql);

            resultSet = pstm.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DBUtils.close(resultSet,pstm,conn);
        }

        return count;
    }

    @Override
    public Student getStudent(int id) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
             conn = DBUtils.getConnection();
             String sql = "select * from student where id = ?";

             pstm = conn.prepareStatement(sql);

             pstm.setInt(1,id);

             resultSet = pstm.executeQuery();

             resultSet.next();
             student = new Student();
             student.setId(resultSet.getInt("id"));
             student.setStudent_id(resultSet.getInt("student_id"));
             student.setName(resultSet.getString("name"));
             student.setAge(resultSet.getInt("age"));
             student.setSex(resultSet.getString("sex"));
             student.setBirthday(resultSet.getDate("birthday"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtils.close(resultSet,pstm,conn);
        }

        return student;
    }
}
