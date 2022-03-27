package com.github.pkg.countryapi.question;

import com.github.pkg.countryapi.questiontype.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTypeOrderByText(QuestionType type);

    @Query(value = "SELECT * FROM question ORDER BY RANDOM() LIMIT ?1", nativeQuery = true)
    List<Question> getRandomQuestions(Integer amount);
}
