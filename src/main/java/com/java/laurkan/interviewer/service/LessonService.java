package com.java.laurkan.interviewer.service;

import com.java.laurkan.interviewer.dto.lesson.CreateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import com.java.laurkan.interviewer.dto.lesson.UpdateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.question.QuestionResponseDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LessonService {
    Page<LessonResponseDTO> findAll(String search, Pageable pageable);

    LessonResponseDTO findById(Long id) throws ResourceNotFoundException;

    List<QuestionResponseDTO> findLessonsOfQuestion(Long id) throws ResourceNotFoundException;

    LessonResponseDTO save(CreateLessonRequestDTO data);

    LessonResponseDTO update(UpdateLessonRequestDTO data) throws ResourceNotFoundException;

    void deleteById(Long lessonId);
}
