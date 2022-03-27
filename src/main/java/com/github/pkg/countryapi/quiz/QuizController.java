package com.github.pkg.countryapi.quiz;

import com.github.pkg.countryapi.question.dto.QuestionSeedResponse;
import com.github.pkg.countryapi.questiontype.QuestionType;
import com.github.pkg.countryapi.seeders.QuizSeederService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/quiz")
@AllArgsConstructor
@Slf4j
public class QuizController {
    private final QuizSeederService quizSeederService;

    @PostMapping("/seed/{type}")
    public ResponseEntity<QuestionSeedResponse> seed(
            @Valid @PathVariable QuestionType type,
            @RequestParam(name = "amount", required = false, defaultValue = "5") Integer amount) {
        quizSeederService.generateQuestions(type, amount);

        return ResponseEntity.ok(new QuestionSeedResponse("Questions Seeded"));
    }
}
