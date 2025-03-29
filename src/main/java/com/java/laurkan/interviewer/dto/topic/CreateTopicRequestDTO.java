package com.java.laurkan.interviewer.dto.topic;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTopicRequestDTO {
    @NotNull
    private String title;
    private Long parentId;
}
