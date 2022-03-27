package com.github.pkg.countryapi.answer;

import com.github.pkg.countryapi.answer.dto.CreateAnswerRequest;
import com.github.pkg.countryapi.country.Country;
import com.github.pkg.countryapi.question.Question;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void createAnswersForCountries(Question question, List<Country> countries, Country correctCountry) {
        log.info("Creating {} answers for '{}'", countries.size(), question.getText());

        // Sort so answers are displayed alphabetically:
        Collections.sort(countries);

        List<Answer> answers = countries
                .stream()
                .map(country -> buildAnswerForCountry(question, country, correctCountry))
                .toList();

        answerRepository.saveAllAndFlush(answers);
    }

    public void createAnswersForQuestion(Question question, List<CreateAnswerRequest> createAnswerRequests) {
        log.info("Creating {} Answers for Question: {}", createAnswerRequests.size(), question.getId());

        List<Answer> answers = createAnswerRequests
                .stream()
                .map(answer -> buildAnswerForQuestion(question, answer))
                .collect(Collectors.toList());

        answerRepository.saveAllAndFlush(answers);
    }

    private Answer buildAnswerForQuestion(Question question, CreateAnswerRequest createAnswerRequest) {
        return Answer.builder()
                .text(createAnswerRequest.getText())
                .isCorrect(createAnswerRequest.getIsCorrect())
                .question(question)
                .build();
    }

    private Answer buildAnswerForCountry(Question question, Country country, Country correctCountry) {
        return Answer.builder()
                .question(question)
                .text(country.getName())
                .isCorrect(Objects.equals(country.getId(), correctCountry.getId()))
                .build();
    }
}
