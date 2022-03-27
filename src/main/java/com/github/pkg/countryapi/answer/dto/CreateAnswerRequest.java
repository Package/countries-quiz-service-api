package com.github.pkg.countryapi.answer.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateAnswerRequest {

    @NotNull
    @Length(max = 255)
    private String text;

    @NotNull
    private Boolean isCorrect;
}
