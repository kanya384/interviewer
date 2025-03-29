package com.java.laurkan.interviewer.repository;

import com.java.laurkan.interviewer.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM Topic t WHERE lower(t.title) LIKE lower(CONCAT('%',:title,'%')) and t.parent is null")
    Page<Topic> findAllByTitleAndParentIsNull(String title, Pageable pageable);

    Page<Topic> findByParentIdIsNull(Pageable pageable);

    List<Topic> findAllByParentId(Long parentId);
}
