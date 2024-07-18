package com.ergashev.quizapp.service;

import com.ergashev.quizapp.Question;
import com.ergashev.quizapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }

}
