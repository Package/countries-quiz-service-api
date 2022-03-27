package com.github.pkg.countryapi.quiz;

import com.github.pkg.countryapi.question.QuestionService;
import com.github.pkg.countryapi.question.Quiz;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class QuizService {
    private final QuestionService questionService;

    public Quiz newQuiz(Integer amount) {
        amount = normalizeAmount(amount);

        return Quiz.builder()
                .questions(questionService.getRandomQuestions(amount))
                .createdAt(LocalDateTime.now())
                .numberOfQuestions(amount)
                .build();
    }

    private Integer normalizeAmount(Integer amount) {
        // Between 1 and 20 questions.
        return Math.max(Math.min(amount, 20), 1);
    }
}
