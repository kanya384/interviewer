package com.java.laurkan.interviewer.dto.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuestionRequestDTO {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    private Long lessonId;

    @NotNull
    @NotBlank
    private String answer;
}
