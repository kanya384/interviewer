package com.java.laurkan.interviewer.service.impl;

import com.java.laurkan.interviewer.dto.lesson.CreateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import com.java.laurkan.interviewer.dto.lesson.UpdateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.question.QuestionResponseDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.mapper.LessonMapper;
import com.java.laurkan.interviewer.mapper.QuestionMapper;
import com.java.laurkan.interviewer.model.Lesson;
import com.java.laurkan.interviewer.repository.LessonRepository;
import com.java.laurkan.interviewer.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final QuestionMapper questionMapper;

    @Override
    public Page<LessonResponseDTO> findAll(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            return lessonRepository.findAllByTitle(search, pageable)
                    .map(lessonMapper::map);
        }

        return lessonRepository.findAll(pageable)
                .map(lessonMapper::map);
    }

    @Override
    public LessonResponseDTO findById(Long id) throws ResourceNotFoundException {
        return lessonRepository.findById(id)
                .map(lessonMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Урок", id));
    }

    @Override
    public List<QuestionResponseDTO> findLessonsOfQuestion(Long id) throws ResourceNotFoundException {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Урок", id))
                .getQuestions()
                .stream()
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .map(questionMapper::map)
                .toList();
    }

    @Override
    public LessonResponseDTO save(CreateLessonRequestDTO data) {
        Lesson lesson = lessonMapper.map(data);
        lessonRepository.save(lesson);
        return lessonMapper.map(lesson);
    }

    @Override
    public LessonResponseDTO update(UpdateLessonRequestDTO data) throws ResourceNotFoundException {
        Lesson lesson = lessonRepository.findById(data.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Урок", data.getId()));
        Lesson updatedLesson = lessonMapper.map(data, lesson);
        lessonRepository.save(updatedLesson);
        return lessonMapper.map(updatedLesson);
    }

    @Override
    public void deleteById(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
