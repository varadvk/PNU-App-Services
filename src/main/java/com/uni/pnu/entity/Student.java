package com.uni.pnu.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentName;
    private String studentAddress;
    private String studentContact;
    private String studentDocumentURL;
    private String profilePictureUrl;

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentDocumentURL() {
        return studentDocumentURL;
    }

    public void setStudentDocumentURL(String studentDocumentURL) {
        this.studentDocumentURL = studentDocumentURL;
    }
}
