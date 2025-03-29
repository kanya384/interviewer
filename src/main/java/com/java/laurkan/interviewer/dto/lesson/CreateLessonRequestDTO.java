package com.java.laurkan.interviewer.dto.lesson;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLessonRequestDTO {
    @NotNull
    private Long topicId;
    @NotNull
    private String title;
    @NotNull
    private String theory;
}
