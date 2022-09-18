package com.gainsight.springdatajpa.repository;

import com.gainsight.springdatajpa.entity.Course;
import com.gainsight.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){

        List<Course> courses = new ArrayList<>();

        Course courseAutomata = Course.builder()
                .title("Automata")
                .credit(5)
                .build();
        courses.add(courseAutomata);
        
        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();
        courses.add(courseJava);

        Teacher teacher = Teacher.builder()
                .firstName("Sandeep")
                .lastName("Dubey")
//                .courses(courses)
                .build();

        repository.save(teacher);

    }
}