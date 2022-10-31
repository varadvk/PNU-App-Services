package com.uni.pnu.service;

import com.uni.pnu.entity.Student;
import com.uni.pnu.util.ExcelUtil;
import com.uni.pnu.util.ExportPDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private ExportPDFUtil exportPDFUtil;

    public ByteArrayInputStream exportStudentData(List<Student> s) {
        return excelUtil.exportToExcel(s);
    }

    public void exportPDF(HttpServletResponse httpServletResponse) throws IOException {
        exportPDFUtil.export(httpServletResponse);
    }
}
