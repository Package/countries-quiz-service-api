package com.github.pkg.countryapi.seeders;

import com.github.pkg.countryapi.answer.AnswerService;
import com.github.pkg.countryapi.country.Country;
import com.github.pkg.countryapi.country.CountryService;
import com.github.pkg.countryapi.question.Question;
import com.github.pkg.countryapi.question.QuestionService;
import com.github.pkg.countryapi.question.dto.CreateQuestionRequest;
import com.github.pkg.countryapi.questiontype.QuestionType;
import com.github.pkg.countryapi.questiontype.QuestionTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class QuizSeederService {
    private final QuestionService questionService;
    private final CountryService countryService;
    private final QuestionTypeService questionTypeService;
    private final AnswerService answerService;

    private static final int MIN_QUESTION_SEED_AMOUNT = 5;
    private static final int MID_QUESTION_SEED_AMOUNT = 15;
    private static final int MAX_QUESTION_SEED_AMOUNT = 25;

    public void seedQuiz() {
        if (questionService.getAllQuestions().size() != 0) {
            log.info("Skipping quiz seeding - already contains data.");
            return;
        }

        generateQuestions(QuestionType.FLAG, MAX_QUESTION_SEED_AMOUNT);
        generateQuestions(QuestionType.CAPITAL_CITY, MAX_QUESTION_SEED_AMOUNT);
        generateQuestions(QuestionType.DOMAIN_EXTENSION, MIN_QUESTION_SEED_AMOUNT);
        generateQuestions(QuestionType.LANGUAGE, MIN_QUESTION_SEED_AMOUNT);
        generateQuestions(QuestionType.POPULATION, MID_QUESTION_SEED_AMOUNT);
        generateQuestions(QuestionType.REGION, MID_QUESTION_SEED_AMOUNT);
    }

    public void generateQuestions(QuestionType type, int amount) {
        amount = normalizeAmount(amount);

        log.info("Generating {} questions of type: {}", amount, type);

        for (int index = 0; index < amount; index++) {
            Country correctCountry = countryService.getCountryForQuestion();

            String exclude = questionTypeService.getExcludedValue(type, correctCountry);
            String text = questionTypeService.getQuestionText(type, correctCountry);
            String mediaUrl = questionTypeService.getQuestionMedia(type, correctCountry);

            CreateQuestionRequest createQuestionRequest =
                    CreateQuestionRequest.builder().text(text).type(type).mediaUrl(mediaUrl).build();
            Question question = questionService.buildQuestion(createQuestionRequest);

            List<Country> wrongCountries = countryService.getCountriesForAnswers(type, exclude);
            wrongCountries.add(correctCountry);
            answerService.createAnswersForCountries(question, wrongCountries, correctCountry);
        }
    }

    private int normalizeAmount(int amount) {
        return Math.min(Math.max(MIN_QUESTION_SEED_AMOUNT, amount), MAX_QUESTION_SEED_AMOUNT);
    }
}
