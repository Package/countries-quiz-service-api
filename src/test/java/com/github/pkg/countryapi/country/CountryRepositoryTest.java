package com.github.pkg.countryapi.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository underTest;

    @Test
    public void findByNameWithValidNameFindsACountry() {
        String name = "United States";

        Optional<Country> country = underTest.findByName(name);

        assertTrue(country.isPresent());
        assertEquals(name, country.get().getName());
    }

    @Test
    public void findByNameWithInvalidNameFindsNothing() {
        String name = "Fake Country";

        Optional<Country> country = underTest.findByName(name);

        assertTrue(country.isEmpty());
    }

    @Test
    public void findAllByOrderByNameAsc() {
        List<Country> countryList = underTest.findAllByOrderByNameAsc();

        assertEquals(10, countryList.size());
        assertEquals("Central America", countryList.get(0).getSubregion());
    }

    @Test
    public void randomCountryWithoutAnAnswer() {
        Country country = underTest.randomCountryWithoutAnAnswer();

        assertNotNull(country);
    }

    @Test
    public void randomCountriesExcludingCapital() {
        String capital = "Port Louis";

        List<Country> countries = underTest.randomCountriesExcludingCapital(capital);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getCapital(), capital));

        assertEquals(3, countries.size());
        assertTrue(result);
    }

    @Test
    public void randomCountriesExcludingDomain() {
        String domain = ".gu";

        List<Country> countries = underTest.randomCountriesExcludingDomain(domain);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getDomainExtension(), domain));

        assertEquals(3, countries.size());
        assertTrue(result);
    }

    @Test
    public void randomCountriesExcludingLanguage() {
        String language = "Georgian";

        List<Country> countries = underTest.randomCountriesExcludingLanguage(language);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getLanguage(), language));

        assertEquals(3, countries.size());
        assertTrue(result);
    }

    @Test
    public void randomCountriesExcludingRegion() {
        String region = "Caribbean";

        List<Country> countries = underTest.randomCountriesExcludingRegion(region);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getSubregion(), region));

        assertEquals(3, countries.size());
        assertTrue(result);
    }

    @Test
    public void randomCountriesPopulationLessThan() {
        String population = "329484123";

        List<Country> countries = underTest.randomCountriesPopulationLessThan(population);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getPopulation(), Long.valueOf(population)));

        assertEquals(3, countries.size());
        assertTrue(result);
    }

    @Test
    public void randomCountriesExcludingFlag() {
        String flag = "https://flagcdn.com/w320/py.png";

        List<Country> countries = underTest.randomCountriesExcludingFlag(flag);
        boolean result = countries.stream().noneMatch(c -> Objects.equals(c.getFlagSrc(), flag));

        assertEquals(3, countries.size());
        assertTrue(result);
    }
}