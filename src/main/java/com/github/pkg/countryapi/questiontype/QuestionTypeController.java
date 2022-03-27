package com.github.pkg.countryapi.questiontype;

import com.github.pkg.countryapi.questiontype.dto.QuestionTypeListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/question-types")
@Tag(name = "Question Type Controller")
public class QuestionTypeController {

    @GetMapping
    @Operation(summary = "Gets all available question types.")
    public ResponseEntity<QuestionTypeListResponse> questionTypes() {
        List<QuestionType> questionTypes = Arrays.stream(QuestionType.values()).collect(Collectors.toList());

        QuestionTypeListResponse response = new QuestionTypeListResponse(questionTypes);

        return ResponseEntity.ok(response);
    }
}
