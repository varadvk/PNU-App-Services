package com.uni.pnu.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SocialTab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;
    private String question;
    @OneToMany
    private List<SocialTabAnswer> answers;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SocialTabAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SocialTabAnswer> answers) {
        this.answers = answers;
    }
}
