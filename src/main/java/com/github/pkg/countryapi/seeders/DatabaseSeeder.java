package com.github.pkg.countryapi.seeders;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeeder implements ApplicationRunner {
    private final CountrySeederService countrySeederService;
    private final QuizSeederService quizSeederService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Attempting to seed Countries");
        countrySeederService.seedCountries();

        log.info("Attempting to seed Quiz");
        quizSeederService.seedQuiz();
    }
}
