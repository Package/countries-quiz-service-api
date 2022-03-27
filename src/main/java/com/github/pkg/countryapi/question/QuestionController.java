package com.github.pkg.countryapi.question;

import com.github.pkg.countryapi.answer.AnswerService;
import com.github.pkg.countryapi.question.dto.CreateQuestionRequest;
import com.github.pkg.countryapi.question.dto.CreateQuestionResponse;
import com.github.pkg.countryapi.questiontype.QuestionType;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@AllArgsConstructor
@Slf4j
@Tag(name = "Question Controller")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @GetMapping
    @Operation(summary = "Get all questions")
    public ResponseEntity<List<Question>> index() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/type/{type}")
    @Operation(summary = "Get all questions of the specified type.")
    public ResponseEntity<List<Question>> type(@Valid @PathVariable QuestionType type) {
        return ResponseEntity.ok(questionService.getQuestionsByType(type));
    }

    @PostMapping
    @Operation(summary = "Creates a question")
    @Hidden
    public ResponseEntity<CreateQuestionResponse> create(@Valid @RequestBody CreateQuestionRequest createQuestionRequest) {
        Question question = questionService.createQuestion(createQuestionRequest);
        answerService.createAnswersForQuestion(question, createQuestionRequest.getAnswers());

        CreateQuestionResponse response = CreateQuestionResponse.builder()
                .message("Question Created Successfully")
                .questionId(question.getId())
                .build();

        return ResponseEntity.ok(response);
    }
}
