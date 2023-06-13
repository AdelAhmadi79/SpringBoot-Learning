package com.school.school.controller;

//import com.example.student.entity.Student;
//import com.example.student.service.StudentService;

import com.school.school.service.StudentService;
import com.school.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private StudentService stService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return stService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return stService.getSingleStudent(id);
    }

    @PostMapping("students")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return stService.saveStudent(student);
    }

    @PutMapping("students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return stService.updateStudent(student);
    }

    @DeleteMapping("/students")
    public String deleteStudent(@RequestParam Long id) {
        stService.deleteStudent(id);
        return "student " + id + " details DELETED";
    }


}