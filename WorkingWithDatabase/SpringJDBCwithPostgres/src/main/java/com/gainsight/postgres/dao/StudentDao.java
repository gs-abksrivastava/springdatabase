package com.gainsight.postgres.dao;

import com.gainsight.postgres.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDao(){

    }

    public void createTable(){
        String query= "Create Table if not exists Student(Id serial primary key, Name varchar(100) not null, City varchar(200) )";
        int res = this.jdbcTemplate.update(query);
        System.out.println("Table Created: "+res );
    }

    public int insert(Student student) {
        String query = "insert into student(id, name, city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }


}
