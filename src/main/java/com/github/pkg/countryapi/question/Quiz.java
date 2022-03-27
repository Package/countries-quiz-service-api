package com.github.pkg.countryapi.question;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Quiz {
    private List<Question> questions;
    private LocalDateTime createdAt;
    private Integer numberOfQuestions;
}
