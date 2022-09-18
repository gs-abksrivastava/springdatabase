package com.gainsight.springbootjdbc;

import com.gainsight.springbootjdbc.dao.StudentDao;
import com.gainsight.springbootjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

    @Autowired
    private StudentDao studentDao;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentDao.createTable();

        int res = studentDao.insert(new Student(4,"Sajal","Pune"));
        System.out.println("Number of records inserted : "+res);

    }
}
