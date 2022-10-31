package com.uni.pnu.controller;

import com.lowagie.text.DocumentException;
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

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        exportService.exportPDF(response);

    }
}
