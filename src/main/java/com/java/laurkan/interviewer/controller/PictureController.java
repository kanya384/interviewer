package com.java.laurkan.interviewer.controller;

import com.java.laurkan.interviewer.dto.picture.CreatePictureRequestDTO;
import com.java.laurkan.interviewer.dto.picture.PictureResponseDTO;
import com.java.laurkan.interviewer.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;

    @PostMapping
    public PictureResponseDTO save(@ModelAttribute CreatePictureRequestDTO data) throws IOException {
        return pictureService.save(data);
    }
}
