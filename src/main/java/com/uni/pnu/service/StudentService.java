package com.uni.pnu.service;

import com.uni.pnu.dao.StudentDao;
import com.uni.pnu.entity.Student;
import com.uni.pnu.util.AWSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AWSUtil awsUtil;

    public Student addStudentDetails(Student student, MultipartFile file, MultipartFile profilePicture) {
        String fileUrl = awsUtil.uploadFile(file);
        String profilePictureUrl = awsUtil.uploadFile(profilePicture);
        student.setStudentDocumentURL(fileUrl);
        student.setProfilePictureUrl(profilePictureUrl);
        return studentDao.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> s = new ArrayList<>();
        studentDao.findAll().forEach(s::add);
        return s;
    }

    public void putBulkStudents() {
        for (int i = 1; i <= 100; i++) {
            Student s = new Student();
            s.setStudentId(i);
            s.setProfilePictureUrl("https://pnubukcet.s3.amazonaws.com/1667229095617-horses-ge578c06d1_1920-min.jpg");
            s.setStudentName("Student - "+ i);
            s.setStudentAddress("Address - "+ i);
            s.setStudentContact("909090 - "+ i);
            s.setStudentDocumentURL("https://pnubukcet.s3.amazonaws.com/1666550996618-hd-wallpaper-g385a9863d_1920-min.jpg");
            studentDao.save(s);
        }
    }
}
