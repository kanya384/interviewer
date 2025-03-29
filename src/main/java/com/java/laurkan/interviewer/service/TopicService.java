package com.java.laurkan.interviewer.service;

import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import com.java.laurkan.interviewer.dto.topic.CreateTopicRequestDTO;
import com.java.laurkan.interviewer.dto.topic.TopicResponseDTO;
import com.java.laurkan.interviewer.dto.topic.UpdateTopicRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    Page<TopicResponseDTO> findAll(String search, Pageable pageable);

    Long findParentOfTopic(Long parentId);
    
    List<TopicResponseDTO> findAllByParentId(Long parentId);

    List<TopicResponseDTO> findAll();

    List<LessonResponseDTO> findLessonsOfTopic(Long topicId) throws ResourceNotFoundException;

    TopicResponseDTO findById(Long id) throws ResourceNotFoundException;

    TopicResponseDTO save(CreateTopicRequestDTO data);

    TopicResponseDTO update(UpdateTopicRequestDTO data) throws ResourceNotFoundException;

    void deleteById(Long directionId);
}
