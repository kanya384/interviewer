package com.java.laurkan.interviewer.dto.picture;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CreatePictureRequestDTO {
    @NotNull
    MultipartFile file;
}
