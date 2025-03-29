package com.java.laurkan.interviewer.service;

import com.java.laurkan.interviewer.dto.picture.CreatePictureRequestDTO;
import com.java.laurkan.interviewer.dto.picture.PictureResponseDTO;

import java.io.IOException;

public interface PictureService {
    PictureResponseDTO save(CreatePictureRequestDTO data) throws IOException;

    void deleteByName(String name) throws IOException;
}
