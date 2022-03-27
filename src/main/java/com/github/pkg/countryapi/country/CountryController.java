package com.github.pkg.countryapi.country;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor
@Slf4j
@Tag(name="Country Controller")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    @Operation(summary = "Get all countries")
    public ResponseEntity<List<Country>> index() {
        List<Country> countries = countryService.getAll();

        return ResponseEntity.ok(countries);
    }
}
