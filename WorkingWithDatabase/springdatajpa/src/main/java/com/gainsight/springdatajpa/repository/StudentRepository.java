package com.gainsight.springdatajpa.repository;

import com.gainsight.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByGuardianName(String name);

    // JPQL
    @Query("select s from Student s where s.emailId= ?1")
    public Student getStudentByEmailId(String emailId);

    // Native
    @Query(
            value = "select * from tbl_student where email_address= ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNative(String emailId);

    // NamedParam
    @Query(
            value = "select * from tbl_student where email_address= :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNamedParam(@Param("emailId") String emailId);


    @Modifying
    @Transactional
    @Query(
            value = "Update tbl_student set first_name = :firstName where email_address = :emailId",
            nativeQuery = true
    )
    public int updateStudentNameByEmailID(String firstName, String emailId);


}
