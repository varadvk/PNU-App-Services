package com.uni.pnu.controller;

import com.uni.pnu.entity.SocialTab;
import com.uni.pnu.entity.SocialTabAnswer;
import com.uni.pnu.service.SocialTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SocialTabController {

    @Autowired
    private SocialTabService socialTabService;

    @PostMapping({"/add/question"})
    public SocialTab addQuestion(@RequestBody SocialTab question) {
        return socialTabService.addQuestion(question);
    }

    @GetMapping({"/search/question/{question}"})
    public List<SocialTab> addQuestion(@PathVariable(name = "question") String question) {
        return socialTabService.searchQuestion(question);
    }

    @GetMapping({"/search/question/id/{questionId}"})
    public SocialTab searchQuestion(@PathVariable(name = "questionId") Integer questionId) {
        return socialTabService.searchQuestion(questionId);
    }

    @PostMapping({"/submit/answer/{questionId}"})
    public SocialTab submitAnswer(@PathVariable(name = "questionId") Integer questionId, @RequestBody SocialTabAnswer socialTabAnswer) {
        return socialTabService.submitAnswer(questionId, socialTabAnswer);
    }

    @GetMapping({"/search/all/question/unanswered"})
    public List<SocialTab> searchUnansweredQuestion() {
        return socialTabService.searchUnansweredQuestion();
    }
}
