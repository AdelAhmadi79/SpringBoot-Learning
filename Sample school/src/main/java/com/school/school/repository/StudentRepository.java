package com.school.school.repository;

import com.school.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentsByName(String name);
    List<Student> findStudentsByNameAndLocation(String name,String location);
    List<Student> findByNameContaining(String keyword);
}
