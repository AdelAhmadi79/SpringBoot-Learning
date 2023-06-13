package com.school.school.service;

import com.school.school.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student saveStudent(Student student);
    Student getSingleStudent(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Student student);
}
