package com.java.laurkan.interviewer.dto.topic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TopicResponseDTO {
    private Long id;
    private String title;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
