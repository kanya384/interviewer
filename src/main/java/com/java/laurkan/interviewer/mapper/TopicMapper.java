package com.java.laurkan.interviewer.mapper;

import com.java.laurkan.interviewer.dto.topic.CreateTopicRequestDTO;
import com.java.laurkan.interviewer.dto.topic.TopicResponseDTO;
import com.java.laurkan.interviewer.dto.topic.UpdateTopicRequestDTO;
import com.java.laurkan.interviewer.model.Topic;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TopicMapper {
    @Mapping(source = "parentId", target = "parent.id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    Topic map(CreateTopicRequestDTO data);

    TopicResponseDTO map(Topic direction);

    Topic map(UpdateTopicRequestDTO data, @MappingTarget Topic direction);

    @AfterMapping
    default void setParentToNullIfEmpty(@MappingTarget Topic topic) {
        if (topic.getParent() != null && topic.getParent().getId() == null) {
            topic.setParent(null);
        }
    }
}
