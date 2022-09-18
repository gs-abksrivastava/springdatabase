package com.gainsight.springdatajpa.repository;

import com.gainsight.springdatajpa.entity.Course;
import com.gainsight.springdatajpa.entity.Student;
import com.gainsight.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println(courses);
    }

//    @Test
//    public void findAllSorted(){
//        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//        System.out.println(courses);
//    }


    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Umesh")
                .lastName("Singh")
                .build();

        Student student = Student.builder()
                .firstName("Aryan")
                .lastName("Srivastava")
                .emailId("aryan@gmail.com")
                .build();

        Course course = Course.builder()
                .title("COA")
                .credit(4)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }

}