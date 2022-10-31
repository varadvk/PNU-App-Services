package com.uni.pnu.service;

import com.uni.pnu.dao.SocialTabDao;
import com.uni.pnu.entity.SocialTab;
import com.uni.pnu.entity.SocialTabAnswer;
import com.uni.pnu.entity.SocialTabAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialTabService {

    @Autowired
    private SocialTabDao socialTabDao;

    @Autowired
    private SocialTabAnswerDao socialTabAnswerDao;

    public SocialTab addQuestion(SocialTab question) {
        return socialTabDao.save(question);
    }

    public List<SocialTab> searchQuestion(String question) {
        return socialTabDao.findByQuestionContainingIgnoreCase(question);
    }

    public SocialTab searchQuestion(Integer questionId) {
        return socialTabDao.findById(questionId).get();
    }

    public SocialTab submitAnswer(Integer questionId, SocialTabAnswer socialTabAnswer) {
        SocialTab socialTab = socialTabDao.findById(questionId).get();
        SocialTabAnswer answer = socialTabAnswerDao.save(socialTabAnswer);
        List<SocialTabAnswer> answers = socialTab.getAnswers();
        answers.add(answer);
        return socialTabDao.save(socialTab);

    }

    public List<SocialTab> searchUnansweredQuestion() {
        List<SocialTab> list = (List<SocialTab>) socialTabDao.findAll();
        return list.stream().filter(x -> x.getAnswers().size() == 0).collect(Collectors.toList());
    }
}
