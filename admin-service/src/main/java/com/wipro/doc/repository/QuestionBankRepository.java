package com.wipro.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doc.entity.QuestionBank;

import java.util.Optional;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long> {
    Optional<QuestionBank> findById(Long id);
}
