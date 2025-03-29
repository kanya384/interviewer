package com.java.laurkan.interviewer.service;

import com.java.laurkan.interviewer.dto.question.CreateQuestionRequestDTO;
import com.java.laurkan.interviewer.dto.question.QuestionResponseDTO;
import com.java.laurkan.interviewer.dto.question.UpdateQuestionRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<QuestionResponseDTO> findAll(String search, Pageable pageable);

    QuestionResponseDTO findById(Long id) throws ResourceNotFoundException;

    QuestionResponseDTO save(CreateQuestionRequestDTO data);

    QuestionResponseDTO update(UpdateQuestionRequestDTO data) throws ResourceNotFoundException;

    void deleteById(Long questionId);
}
