package com.github.pkg.countryapi.country;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class CountryResponse {
    private Name name;
    private String[] capital;
    private String[] tld;
    private String subregion;
    private Long population;
    private Flags flags;
    private Map<String, String> languages;

    public boolean isValid() {
        return name != null &&
                capital != null &&
                subregion != null &&
                population != null &&
                flags != null &&
                languages != null;
    }

    public String getPrimaryLanguage() {
        return languages.values().stream().findFirst().orElse(null);
    }

    public String getDomainExtension() {
        if (tld == null) {
            return null;
        }

        return tld[0];
    }

    @Data
    public static class Name {
        private String common;
    }

    @Data
    public static class Flags {
        private String png;
        private String svg;
    }
}

