package com.gainsight.jdbc;

import com.gainsight.jdbc.dao.StudentDao;
import com.gainsight.jdbc.dao.StudentDaoImpl;
import com.gainsight.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Application Started");
//        spring jdbc -> jdbcTemplate

        /*

            //with Xml
            ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/com/gainsight/jdbc/config.xml");
         */

//        JdbcTemplate jdbcTemplate = context.getBean("jdbctemplate", JdbcTemplate.class);

        /*
        // With Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);

         */

        //With AutoWiring
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);

        StudentDao studentdao = context.getBean("studentDao", StudentDao.class);

//        //insert
//        String query = "insert into student(id, name, city) values(?,?,?)";
//        int result = jdbcTemplate.update(query,2,"Aryan","Lucknow");
       /*
        Student st = new Student(4,"Manish","Delhi");
        int result = studentdao.insert(st);
        System.out.println("Number of records inserted : "+result);

        */

/*
        //Update
        Student student = new Student(1,"Abhishek Srivastava","Hyderabad");
        int result = studentdao.update(student);
        System.out.println("Number of records updated : "+result);

 */

 /*
        //Delete
        int res = studentdao.delete(4);
        System.out.println("Number of records deleted : "+res);

  */
        /*
        //Selecting a student
        Student st = studentdao.getStudent(2);
        System.out.println("Student is ; "+ st);
         */

        //Selecting All Students
        List<Student> studentList = studentdao.getAllStudents();
        for(Student student : studentList){
            System.out.println(student);
        }



    }
}
