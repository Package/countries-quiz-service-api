package com.github.pkg.countryapi.questiontype;

import com.github.pkg.countryapi.questiontype.dto.QuestionTypeListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/question-types")
public class QuestionTypeController {

    @GetMapping
    public ResponseEntity<QuestionTypeListResponse> questionTypes() {
        List<QuestionType> questionTypes = Arrays.stream(QuestionType.values()).toList();

        QuestionTypeListResponse response = new QuestionTypeListResponse(questionTypes);

        return ResponseEntity.ok(response);
    }
}
