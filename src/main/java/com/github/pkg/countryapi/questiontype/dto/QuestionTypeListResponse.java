package com.github.pkg.countryapi.questiontype.dto;

import com.github.pkg.countryapi.questiontype.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionTypeListResponse {
    private List<QuestionType> types;
}
