package com.github.pkg.countryapi.quiz;

import com.github.pkg.countryapi.question.Quiz;
import com.github.pkg.countryapi.question.dto.QuestionSeedResponse;
import com.github.pkg.countryapi.questiontype.QuestionType;
import com.github.pkg.countryapi.seeders.QuizSeederService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/quiz")
@AllArgsConstructor
@Slf4j
@Tag(name = "Quiz Controller")
public class QuizController {
    private final QuizSeederService quizSeederService;
    private final QuizService quizService;

    @GetMapping("/new")
    @Operation(summary = "Returns a new quiz")
    public ResponseEntity<Quiz> quiz(@RequestParam(name = "amount", required = false, defaultValue = "10") Integer amount) {
        Quiz quiz = quizService.newQuiz(amount);

        return ResponseEntity.ok(quiz);
    }

    @PostMapping("/seed/{type}")
    @Operation(summary = "Seeds the database with questions of the provided type.")
    @Hidden
    public ResponseEntity<QuestionSeedResponse> seed(
            @Valid @PathVariable QuestionType type,
            @RequestParam(name = "amount", required = false, defaultValue = "5") Integer amount) {
        quizSeederService.generateQuestions(type, amount);

        return ResponseEntity.ok(new QuestionSeedResponse("Questions Seeded"));
    }
}
