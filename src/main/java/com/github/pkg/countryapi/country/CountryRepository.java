package com.github.pkg.countryapi.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByName(String name);

    List<Country> findAllByOrderByNameAsc();

    @Query(value = "SELECT c.* " +
            "FROM country c " +
            "LEFT OUTER JOIN answer a ON a.text = c.name AND a.is_correct = TRUE " +
            "WHERE a.id IS NULL " +
            "ORDER BY RANDOM() " +
            "LIMIT 1", nativeQuery = true)
    Country randomCountryWithoutAnAnswer();

    @Query(value = "SELECT * FROM country WHERE capital <> ?1 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesExcludingCapital(String capital);

    @Query(value = "SELECT * FROM country WHERE domain_extension <> ?1 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesExcludingDomain(String domain);

    @Query(value = "SELECT * FROM country WHERE language <> ?1 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesExcludingLanguage(String language);

    @Query(value = "SELECT * FROM country WHERE subregion <> ?1 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesExcludingRegion(String region);

    @Query(value = "SELECT * FROM country WHERE population < CAST(?1 AS BIGINT) ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesPopulationLessThan(String population);

    @Query(value = "SELECT * FROM country WHERE flag_src <> ?1 ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
    List<Country> randomCountriesExcludingFlag(String flag);
}
