package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public ArrayList<StudentEntity> getStudents() {
        return (ArrayList<StudentEntity>) studentRepository.findAll();
    }

    public StudentEntity getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentEntity updateStudent(Integer id, StudentEntity student) {
        return studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public Page<StudentEntity> getStudents(int pageno, int size) {
        PageRequest pageable = PageRequest.of(pageno, size);
        return studentRepository.findAll(pageable);
    }
}
