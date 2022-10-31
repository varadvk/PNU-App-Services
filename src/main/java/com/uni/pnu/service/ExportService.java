package com.uni.pnu.service;

import com.uni.pnu.entity.Student;
import com.uni.pnu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private ExcelUtil excelUtil;

    public ByteArrayInputStream exportStudentData(List<Student> s) {
        return excelUtil.exportToExcel(s);
    }
}
