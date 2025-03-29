package com.java.laurkan.interviewer.dto.question;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateQuestionRequestDTO {
    @NotNull
    private Long id;
    private String title;
    private String answer;
}
