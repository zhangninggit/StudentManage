package com.dabiao.dao;

import com.dabiao.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    List<Student> findAll() throws SQLException;   // 查询所有学生信息

    void add(Student student) throws SQLException; // 添加一位学生的信息

    void delete(int id); // 删除一位学生信息

    void update(Student student); // 修改一位学生信息

    int getTotal(); // 查询学生总数

    Student getStudent(int id); // 根据id获取学生信息

    List<Student> findAllPage(int currentPage,int rows);

    boolean Login(String username,String password);
}
