package com.github.pkg.countryapi.seeders;

import com.github.pkg.countryapi.country.CountryResponse;
import com.github.pkg.countryapi.country.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@AllArgsConstructor
@Slf4j
public class CountrySeederService {
    private final CountryService countryService;
    private static final String COUNTRY_API_ENDPOINT = "https://restcountries.com/v3.1/all";

    public void seedCountries() {
        if (countryService.getCountryCount() > 0) {
            log.info("Skipping country seeding - already contains data.");
            return;
        }

        RestTemplate restTemplate = new RestTemplate();

        CountryResponse[] countriesFromApi = restTemplate.getForObject(COUNTRY_API_ENDPOINT, CountryResponse[].class);
        if (countriesFromApi == null) {
            log.error("Error fetching countries from external service.");
            return;
        }

        Arrays.stream(countriesFromApi).forEach(countryService::upsertCountry);

        log.info("Seeded {} countries from {}", countriesFromApi.length, COUNTRY_API_ENDPOINT);
    }
}
