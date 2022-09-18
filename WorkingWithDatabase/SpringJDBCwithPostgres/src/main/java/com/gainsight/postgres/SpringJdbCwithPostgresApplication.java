package com.gainsight.postgres;

import com.gainsight.postgres.dao.StudentDao;
import com.gainsight.postgres.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbCwithPostgresApplication implements CommandLineRunner {

    @Autowired
    private StudentDao studentDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbCwithPostgresApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//                studentDao.createTable();

        int res = studentDao.insert(new Student(4,"Abhishek","Lucknow"));
        System.out.println("Number of records inserted : "+res);
    }

}
