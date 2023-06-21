package com.school.school.service;

import com.school.school.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student saveStudent(Student student);
    Student getSingleStudent(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Student student);

    //In Fact this method is kinda a filter by name
    List<Student> getStudentsByName(String name);

    List<Student> getStudentsByNameAndLocation(String name, String location);

}
