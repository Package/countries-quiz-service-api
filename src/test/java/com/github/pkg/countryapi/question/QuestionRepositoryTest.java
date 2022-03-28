package com.github.pkg.countryapi.question;

import com.github.pkg.countryapi.questiontype.QuestionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository underTest;

    @Test
    public void findByTypeOrderByText() {
        QuestionType type = QuestionType.FLAG;

        List<Question> flagQuestions = underTest.findByTypeOrderByText(type);

        assertEquals(1, flagQuestions.size());
    }

    @Test
    public void getRandomQuestions() {
        List<Question> randomQuestions = underTest.getRandomQuestions(2);

        assertEquals(2, randomQuestions.size());
    }
}