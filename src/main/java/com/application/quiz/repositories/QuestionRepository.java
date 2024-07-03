package com.application.quiz.repositories;

import com.application.quiz.entities.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("Select q.id, q.question from Question q")
    Page<String> getAllQuestionsWithoutAnswer(Pageable pageable);
}
