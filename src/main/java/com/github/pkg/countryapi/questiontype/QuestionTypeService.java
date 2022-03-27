package com.github.pkg.countryapi.questiontype;

import com.github.pkg.countryapi.country.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
@AllArgsConstructor
public class QuestionTypeService {

    public String getQuestionText(QuestionType type, Country correctCountry) {
        switch (type) {
            case FLAG:
                return "Which country does this flag belong to?";
            case DOMAIN_EXTENSION:
                return "Which country uses this as their Internet Domain?";
            case REGION:
                return "Which country is in this region of the World?";
            case CAPITAL_CITY:
                return correctCountry.getCapital() + " is the capital of which country?";
            case POPULATION:
                return "Which country has a population of " + NumberFormat.getInstance().format(correctCountry.getPopulation()) + "?";
            case LANGUAGE:
                return "In which country is " + correctCountry.getLanguage() + " a primary spoken language?";
            default:
                return null;
        }
    }

    public String getExcludedValue(QuestionType type, Country correctCountry) {
        switch (type) {
            case FLAG:
                return correctCountry.getFlagSrc();
            case DOMAIN_EXTENSION:
                return correctCountry.getDomainExtension();
            case REGION:
                return correctCountry.getSubregion();
            case CAPITAL_CITY:
                return correctCountry.getCapital();
            case POPULATION:
                return String.valueOf(correctCountry.getPopulation());
            case LANGUAGE:
                return correctCountry.getLanguage();
            default:
                return null;
        }
    }

    public String getQuestionMedia(QuestionType type, Country correctCountry) {
        switch (type) {
            case FLAG:
                return correctCountry.getFlagSrc();
            default:
                return null;
        }
    }
}
