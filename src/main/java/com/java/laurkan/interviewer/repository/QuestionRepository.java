package com.java.laurkan.interviewer.repository;

import com.java.laurkan.interviewer.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.title LIKE CONCAT('%',:title,'%')")
    Page<Question> findAllByTitle(String title, Pageable pageable);
}
