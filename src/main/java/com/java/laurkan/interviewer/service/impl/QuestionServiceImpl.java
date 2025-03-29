package com.java.laurkan.interviewer.service.impl;

import com.java.laurkan.interviewer.dto.question.CreateQuestionRequestDTO;
import com.java.laurkan.interviewer.dto.question.QuestionResponseDTO;
import com.java.laurkan.interviewer.dto.question.UpdateQuestionRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.mapper.QuestionMapper;
import com.java.laurkan.interviewer.model.Question;
import com.java.laurkan.interviewer.repository.QuestionRepository;
import com.java.laurkan.interviewer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public Page<QuestionResponseDTO> findAll(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            return questionRepository.findAllByTitle(search, pageable)
                    .map(questionMapper::map);
        }

        return questionRepository.findAll(pageable)
                .map(questionMapper::map);
    }

    @Override
    public QuestionResponseDTO findById(Long id) throws ResourceNotFoundException {
        return questionRepository.findById(id)
                .map(questionMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Вопрос", id));
    }

    @Override
    public QuestionResponseDTO save(CreateQuestionRequestDTO data) {
        Question question = questionMapper.map(data);
        questionRepository.save(question);
        return questionMapper.map(question);
    }

    @Override
    public QuestionResponseDTO update(UpdateQuestionRequestDTO data) throws ResourceNotFoundException {
        Question question = questionRepository.findById(data.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Вопрос", data.getId()));
        var updatedQuestion = questionMapper.map(data, question);
        return questionMapper.map(questionRepository.save(updatedQuestion));
    }

    @Override
    public void deleteById(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
