package com.java.laurkan.interviewer.mapper;

import com.java.laurkan.interviewer.dto.lesson.CreateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import com.java.laurkan.interviewer.dto.lesson.UpdateLessonRequestDTO;
import com.java.laurkan.interviewer.model.Lesson;
import com.java.laurkan.interviewer.model.Topic;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface LessonMapper {
    @Mapping(source = "topicId", target = "topic.id")
    Lesson map(CreateLessonRequestDTO data);

    LessonResponseDTO map(Lesson lesson);

    default Lesson map(UpdateLessonRequestDTO data, @MappingTarget Lesson lesson) {
        if (data.getTitle() != null) {
            lesson.setTitle(data.getTitle());
        }

        if (data.getTheory() != null) {
            lesson.setTheory(data.getTheory());
        }

        if (data.getTopicId() != null) {
            var topic = new Topic();
            topic.setId(data.getTopicId());
            lesson.setTopic(topic);
        }
        return lesson;
    }
}
