package com.uni.pnu.controller;

import com.uni.pnu.entity.Student;
import com.uni.pnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void putBulkStudents() {
        studentService.putBulkStudents();
    }

    @PostMapping({"/addStudentDetails"})
    public Student addStudentDetails(@RequestPart("studentData") Student student,
                                     @RequestPart("studentDocuments") MultipartFile file) {
        return studentService.addStudentDetails(student, file);
    }

    @GetMapping({"/getAllStudents"})
    public List<Student> addStudentDetails() {
        return studentService.getAllStudents();
    }
}
