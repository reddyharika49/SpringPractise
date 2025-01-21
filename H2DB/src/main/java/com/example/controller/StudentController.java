package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.StudentEntity;
import com.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudents")
    public ArrayList<StudentEntity> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/getStudentByID/{id}")
    public StudentEntity getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public StudentEntity updateStudent(@PathVariable("id") int id, @RequestBody StudentEntity student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
    
    @GetMapping("/pagination")
    public Page<StudentEntity> getStudents(@RequestParam int pageno, @RequestParam int size) {
        return studentService.getStudents(pageno, size);
    }
}
