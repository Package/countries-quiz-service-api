package com.github.pkg.countryapi.question.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuestionResponse {
    private String message;
    private Integer questionId;
}
