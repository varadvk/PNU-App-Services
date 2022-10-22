package com.uni.pnu.controller;

import com.uni.pnu.entity.Student;
import com.uni.pnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping({"/addStudentDetails"})
    public Student addStudentDetails(@RequestPart("studentData") Student student,
                                     @RequestPart("studentDocuments") MultipartFile file) {
        return studentService.addStudentDetails(student, file);
    }
}
