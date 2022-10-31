package com.uni.pnu.util;

import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.uni.pnu.dao.StudentDao;
import com.uni.pnu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
public class ExportPDFUtil {

    @Autowired
    private StudentDao studentDao;

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("PP", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Contact", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Doc Url", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table, List<Student> studentList) throws IOException {
        for (Student student : studentList) {
            Image image = Image.getInstance(student.getProfilePictureUrl());
            table.addCell(String.valueOf(student.getStudentId()));
            table.addCell(image);
            table.addCell(student.getStudentName());
            table.addCell(student.getStudentAddress());
            table.addCell(student.getStudentContact());
            table.addCell(student.getStudentDocumentURL());
            break;
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.ORANGE);

        Paragraph p = new Paragraph("Here's the exported data", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{0.5f, 1.0f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);

        List<Student> students = (List<Student>) studentDao.findAll();
        writeTableData(table, students);

        document.add(table);

        document.close();

    }
}
