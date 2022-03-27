package com.github.pkg.countryapi.question.dto;

import com.github.pkg.countryapi.answer.dto.CreateAnswerRequest;
import com.github.pkg.countryapi.question.QuestionService;
import com.github.pkg.countryapi.questiontype.QuestionType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class CreateQuestionRequest {

    @NotNull
    @Length(min = 6, max = 255)
    private String text;

    @Length(max = 255)
    private String mediaUrl;

    @NotNull
    private QuestionType type;

    @NotNull
    @Size(min = QuestionService.NUM_ANSWERS, max = QuestionService.NUM_ANSWERS, message = "Must provide required number of answers.")
    private List<CreateAnswerRequest> answers;
}
