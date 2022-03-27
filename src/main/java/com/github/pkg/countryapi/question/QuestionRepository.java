package com.github.pkg.countryapi.question;

import com.github.pkg.countryapi.questiontype.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTypeOrderByText(QuestionType type);
}
