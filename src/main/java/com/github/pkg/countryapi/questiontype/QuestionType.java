package com.github.pkg.countryapi.questiontype;

import lombok.Getter;

public enum QuestionType {
    CAPITAL_CITY("CAPITAL_CITY"),
    POPULATION("POPULATION"),
    REGION("REGION"),
    FLAG("FLAG"),
    LANGUAGE("LANGUAGE"),
    DOMAIN_EXTENSION("DOMAIN_EXTENSION");

    @Getter
    final String questionType;

    QuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return this.questionType;
    }
}
