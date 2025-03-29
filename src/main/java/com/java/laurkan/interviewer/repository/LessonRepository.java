package com.java.laurkan.interviewer.repository;

import com.java.laurkan.interviewer.model.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("SELECT l FROM Lesson l WHERE l.title LIKE CONCAT('%',:title,'%')")
    Page<Lesson> findAllByTitle(String title, Pageable pageable);
}
