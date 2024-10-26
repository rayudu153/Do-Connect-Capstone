package com.wipro.doc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.doc.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);

    @Query("SELECT a FROM Answer a JOIN FETCH a.question WHERE a.id = :id")
    Optional<Answer> findByIdWithQuestion(@Param("id") Long id);

}
