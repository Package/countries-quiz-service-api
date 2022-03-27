package com.github.pkg.countryapi.question;

import com.github.pkg.countryapi.answer.dto.CreateAnswerRequest;
import com.github.pkg.countryapi.exceptions.BadRequestException;
import com.github.pkg.countryapi.question.dto.CreateQuestionRequest;
import com.github.pkg.countryapi.questiontype.QuestionType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionService {
    public static final int NUM_CORRECT_ANSWERS = 1;
    public static final int NUM_ANSWERS = 4;

    private final QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByType(QuestionType type) {
        return questionRepository.findByTypeOrderByText(type);
    }

    public Question buildQuestion(CreateQuestionRequest createQuestionRequest) {
        return Question
                .builder()
                .text(createQuestionRequest.getText())
                .mediaUrl(createQuestionRequest.getMediaUrl())
                .type(createQuestionRequest.getType())
                .build();
    }

    public Question createQuestion(CreateQuestionRequest createQuestionRequest) {
        validateOneCorrectAnswer(createQuestionRequest);
        validateUniqueAnswers(createQuestionRequest);

        Question question = buildQuestion(createQuestionRequest);

        return questionRepository.saveAndFlush(question);
    }

    private void validateOneCorrectAnswer(CreateQuestionRequest createQuestionRequest) {
        long numberOfCorrectAnswers = createQuestionRequest.getAnswers().stream().filter(CreateAnswerRequest::getIsCorrect).count();
        if (numberOfCorrectAnswers != NUM_CORRECT_ANSWERS) {
            throw new BadRequestException(NUM_CORRECT_ANSWERS + " answer(s) must be marked as correct.");
        }
    }

    private void validateUniqueAnswers(CreateQuestionRequest createQuestionRequest) {
        Set<String> answerTexts = createQuestionRequest.getAnswers().stream().map(CreateAnswerRequest::getText).collect(Collectors.toSet());
        if (answerTexts.size() != NUM_ANSWERS) {
            throw new BadRequestException("Answers must be unique.");
        }
    }
}
