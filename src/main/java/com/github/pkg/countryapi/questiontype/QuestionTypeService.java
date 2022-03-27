package com.github.pkg.countryapi.questiontype;

import com.github.pkg.countryapi.country.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
@AllArgsConstructor
public class QuestionTypeService {

    public String getQuestionText(QuestionType type, Country correctCountry) {
        return switch (type) {
            case FLAG -> "Which country does this flag belong to?";
            case DOMAIN_EXTENSION -> "Which country uses this as their Internet Domain?";
            case REGION -> "Which country is in this region of the World?";
            case CAPITAL_CITY -> correctCountry.getCapital() + " is the capital of which country?";
            case POPULATION -> "Which country has a population of " + NumberFormat.getInstance().format(correctCountry.getPopulation()) + "?";
            case LANGUAGE -> "In which country is " + correctCountry.getLanguage() + " a primary spoken language?";
        };
    }

    public String getExcludedValue(QuestionType type, Country correctCountry) {
        return switch (type) {
            case FLAG -> correctCountry.getFlagSrc();
            case DOMAIN_EXTENSION -> correctCountry.getDomainExtension();
            case REGION -> correctCountry.getSubregion();
            case CAPITAL_CITY -> correctCountry.getCapital();
            case POPULATION -> String.valueOf(correctCountry.getPopulation());
            case LANGUAGE -> correctCountry.getLanguage();
        };
    }

    public String getQuestionMedia(QuestionType type, Country correctCountry) {
        return switch (type) {
            case FLAG -> correctCountry.getFlagSrc();
            default -> null;
        };
    }
}
