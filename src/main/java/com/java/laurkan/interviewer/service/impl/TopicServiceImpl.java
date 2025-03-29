package com.java.laurkan.interviewer.service.impl;

import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import com.java.laurkan.interviewer.dto.topic.CreateTopicRequestDTO;
import com.java.laurkan.interviewer.dto.topic.TopicResponseDTO;
import com.java.laurkan.interviewer.dto.topic.UpdateTopicRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.mapper.LessonMapper;
import com.java.laurkan.interviewer.mapper.TopicMapper;
import com.java.laurkan.interviewer.model.Topic;
import com.java.laurkan.interviewer.repository.TopicRepository;
import com.java.laurkan.interviewer.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final LessonMapper lessonMapper;

    @Override
    public Page<TopicResponseDTO> findAll(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            return topicRepository.findAllByTitleAndParentIsNull(search, pageable)
                    .map(topicMapper::map);
        }

        return topicRepository.findByParentIdIsNull(pageable)
                .map(topicMapper::map);
    }

    @Override
    public Long findParentOfTopic(Long topicId) {
        var topic = topicRepository.findById(topicId)
                .orElse(null);

        if (topic == null || topic.getParent() == null) {
            return null;
        }

        return topic.getParent().getId();
    }

    @Override
    public List<TopicResponseDTO> findAllByParentId(Long parentId) {
        return topicRepository.findAllByParentId(parentId)
                .stream()
                .map(topicMapper::map)
                .toList();
    }

    @Override
    public List<TopicResponseDTO> findAll() {
        return topicRepository.findAll()
                .stream()
                .map(topicMapper::map)
                .toList();
    }

    @Override
    public List<LessonResponseDTO> findLessonsOfTopic(Long topicId) throws ResourceNotFoundException {
        return topicRepository.findById(topicId)
                .orElseThrow(() -> new ResourceNotFoundException("Топик", topicId))
                .getLessons()
                .stream()
                .map(lessonMapper::map)
                .toList();
    }

    @Override
    public TopicResponseDTO findById(Long id) throws ResourceNotFoundException {
        return topicRepository.findById(id)
                .map(topicMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Направление", id));
    }

    @Override
    public TopicResponseDTO save(CreateTopicRequestDTO data) {
        Topic topic = topicMapper.map(data);
        topicRepository.save(topic);
        return topicMapper.map(topic);
    }

    @Override
    @Transactional
    public TopicResponseDTO update(UpdateTopicRequestDTO data) throws ResourceNotFoundException {
        Topic topic = topicRepository.findById(data.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Направление", data.getId()));
        Topic updatedTopic = topicMapper.map(data, topic);
        topicRepository.save(topic);
        return topicMapper.map(updatedTopic);
    }

    @Override
    public void deleteById(Long topicId) {
        topicRepository.deleteById(topicId);
    }
}
