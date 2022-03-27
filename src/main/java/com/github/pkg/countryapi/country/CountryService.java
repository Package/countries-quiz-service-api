package com.github.pkg.countryapi.country;

import com.github.pkg.countryapi.questiontype.QuestionType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public long getCountryCount() {
        return countryRepository.count();
    }

    public Country getByName(String name) {
        return countryRepository.findByName(name).orElse(new Country());
    }

    public List<Country> getAll() {
        return countryRepository.findAllByOrderByNameAsc();
    }

    public void upsertCountry(CountryResponse countryResponse) {
        if (!countryResponse.isValid()) {
            log.info("Skipping {} as it's invalid", countryResponse);
            return;
        }

        Country country = getByName(countryResponse.getName().getCommon());
        country.setName(countryResponse.getName().getCommon());
        country.setPopulation(countryResponse.getPopulation());
        country.setLanguage(countryResponse.getPrimaryLanguage());
        country.setSubregion(countryResponse.getSubregion());
        country.setDomainExtension(countryResponse.getDomainExtension());
        country.setCapital(countryResponse.getCapital()[0]);
        country.setFlagSrc(countryResponse.getFlags().getPng());

        countryRepository.save(country);
    }

    public Country getCountryForQuestion() {
        return countryRepository.randomCountryWithoutAnAnswer();
    }

    public List<Country> getCountriesForAnswers(QuestionType type, String exclude) {
        return switch (type) {
            case FLAG -> countryRepository.randomCountriesExcludingFlag(exclude);
            case CAPITAL_CITY -> countryRepository.randomCountriesExcludingCapital(exclude);
            case DOMAIN_EXTENSION -> countryRepository.randomCountriesExcludingDomain(exclude);
            case LANGUAGE -> countryRepository.randomCountriesExcludingLanguage(exclude);
            case POPULATION -> countryRepository.randomCountriesPopulationLessThan(exclude);
            case REGION -> countryRepository.randomCountriesExcludingRegion(exclude);
        };
    }
}
