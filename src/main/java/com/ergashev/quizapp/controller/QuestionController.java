package com.ergashev.quizapp.controller;

import com.ergashev.quizapp.Question;
import com.ergashev.quizapp.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(
            QuestionService questionService
    ) {
    this.questionService = questionService;
    }

    @GetMapping("all-question")
    public ResponseEntity<List<Question>> getAllQuestions() {
            return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

}
