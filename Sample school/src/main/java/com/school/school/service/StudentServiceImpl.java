package com.school.school.service;

import com.school.school.model.Student;
import com.school.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository sRepository;

    @Override
    public List<Student> getStudents(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber,pageSize);
        return sRepository.findAll(pages).getContent();
    }

    @Override
    public Student saveStudent(Student student) {
        return sRepository.save(student);
    }

    @Override
    public Student getSingleStudent(Long id) {
        Optional<Student> student = sRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else
            throw new RuntimeException("Student with id \"" + id + "\" has not found");
    }

    @Override
    public void deleteStudent(Long id) {
        sRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return sRepository.save(student);
        //if student obj has id ==> update , if not ==> saveStudent
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return sRepository.findStudentsByName(name);
    }

    @Override
    public List<Student> getStudentsByNameAndLocation(String name, String location) {
        return sRepository.findStudentsByNameAndLocation(name,location);
    }

    @Override
    public List<Student> getStudentsByNameKeyword(String keyword) {
        return sRepository.findByNameContaining(keyword);
    }


}
