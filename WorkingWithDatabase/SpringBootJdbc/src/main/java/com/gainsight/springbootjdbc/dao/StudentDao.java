package com.gainsight.springbootjdbc.dao;

import com.gainsight.springbootjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDao(){

    }

    public void createTable(){
        String query= "Create Table if not exists Student(Id int primary key, Name varchar(100), City varchar(200))";
        this.jdbcTemplate.update(query);
        System.out.println("Table Created");
    }

    public int insert(Student student) {
        String query = "insert into student(id, name, city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }


}
