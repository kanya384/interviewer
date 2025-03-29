package com.java.laurkan.interviewer.mapper;

import com.java.laurkan.interviewer.dto.question.CreateQuestionRequestDTO;
import com.java.laurkan.interviewer.dto.question.QuestionResponseDTO;
import com.java.laurkan.interviewer.dto.question.UpdateQuestionRequestDTO;
import com.java.laurkan.interviewer.model.Question;
import org.mapstruct.*;

@Mapper(
        uses = LessonMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface QuestionMapper {
    @Mapping(source = "lessonId", target = "lesson.id")
    Question map(CreateQuestionRequestDTO data);

    QuestionResponseDTO map(Question question);

    default Question map(UpdateQuestionRequestDTO data, @MappingTarget Question question) {

        question.setId(data.getId());

        if (data.getTitle() != null) {
            question.setTitle(data.getTitle());
        }

        if (data.getAnswer() != null) {
            question.setAnswer(data.getAnswer());
        }

        return question;
    }
}
