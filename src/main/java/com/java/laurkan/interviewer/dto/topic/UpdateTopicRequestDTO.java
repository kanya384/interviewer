package com.java.laurkan.interviewer.dto.topic;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTopicRequestDTO {
    @NotNull
    private Long id;
    private String title;
    private Long parentId;
}
