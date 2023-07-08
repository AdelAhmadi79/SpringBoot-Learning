package com.school.school.service;

import com.school.school.model.Student;
import com.school.school.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository sRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents(int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pages = PageRequest.of(pageNumber, pageSize, sort);
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }

    @Override
    public void deleteStudent(Long id) {
        sRepository.deleteById(id);
    }


    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student managedStudent = sRepository.saveAndFlush(student);
        entityManager.refresh(managedStudent);
        return sRepository.findById(student.getId()).get();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return sRepository.findStudentsByName(name);
    }

    @Override
    public List<Student> getStudentsByNameAndLocation(String name, String location) {
        return sRepository.findStudentsByNameAndLocation(name, location);
    }

    @Override
    public List<Student> getStudentsByNameKeyword(String keyword) {
        return sRepository.findByNameContaining(keyword);
    }


}
