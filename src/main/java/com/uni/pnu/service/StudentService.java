package com.uni.pnu.service;

import com.uni.pnu.dao.StudentDao;
import com.uni.pnu.entity.Student;
import com.uni.pnu.util.AWSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AWSUtil awsUtil;

    public Student addStudentDetails(Student student, MultipartFile file) {
        String fileUrl = awsUtil.uploadFile(file);
        student.setStudentDocumentURL(fileUrl);
        return studentDao.save(student);
    }
}
