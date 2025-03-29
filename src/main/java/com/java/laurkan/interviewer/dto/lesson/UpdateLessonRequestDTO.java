package com.java.laurkan.interviewer.dto.lesson;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLessonRequestDTO {
    @NotNull
    private Long id;
    private Long topicId;
    private String title;
    private String theory;
}
