package com.java.laurkan.interviewer.dto.lesson;

import com.java.laurkan.interviewer.dto.topic.TopicResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LessonResponseDTO {
    private Long id;
    private TopicResponseDTO topic;
    private String title;
    private String theory;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
