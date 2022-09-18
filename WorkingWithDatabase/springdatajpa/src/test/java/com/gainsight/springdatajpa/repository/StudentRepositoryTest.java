package com.gainsight.springdatajpa.repository;

import com.gainsight.springdatajpa.entity.Guardian;
import com.gainsight.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("abhi@gs.com")
                .firstName("Abhishek")
                .lastName("Srivastava")
//                .guardianName("Umesh")
//                .guardianEmail("umesh@gmail.com")
//                .guardianMobile("6457524272")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Umesh")
                .email("umesh@gmail.com")
                .mobile("6457524272")
                .build();

        Student student = Student.builder()
                .firstName("Adarsh")
                .lastName("Srivastava")
                .emailId("adarsh@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents(){
        List <Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Adarsh");
        System.out.println(students);
    }
    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("A");
        System.out.println(students);
    }
    @Test
    public void getStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("umesh");
        System.out.println(students);
    }

    @Test
    public void getStudentByEmail(){
        Student student = studentRepository.getStudentByEmailId("abhi@gs.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailIdNative("abhi@gs.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailNamedParam(){
        Student student = studentRepository.getStudentByEmailIdNamedParam("abhi@gs.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailID(){
        int res = studentRepository.updateStudentNameByEmailID("Abhi","abhi@gs.com");
    }
}