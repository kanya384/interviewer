package com.java.laurkan.interviewer.dto.question;

import com.java.laurkan.interviewer.dto.lesson.LessonResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class QuestionResponseDTO {
    private Long id;
    private String title;
    private String answer;
    private LessonResponseDTO lesson;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
