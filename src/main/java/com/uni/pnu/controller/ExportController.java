package com.uni.pnu.controller;

import com.uni.pnu.entity.Student;
import com.uni.pnu.service.ExportService;
import com.uni.pnu.service.StudentService;
import com.uni.pnu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@CrossOrigin
public class ExportController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private ExportService exportService;

    @GetMapping({"/exportData"})
    public ResponseEntity<InputStreamResource> exportStudentData() {
        List<Student> s = studentService.getAllStudents();
        ByteArrayInputStream byteArrayInputStream = exportService.exportStudentData(s);

        String filename = "student.xlsx";
        InputStreamResource file = new InputStreamResource(byteArrayInputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
