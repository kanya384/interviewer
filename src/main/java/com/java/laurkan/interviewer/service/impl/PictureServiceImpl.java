package com.java.laurkan.interviewer.service.impl;

import com.java.laurkan.interviewer.dto.picture.CreatePictureRequestDTO;
import com.java.laurkan.interviewer.dto.picture.PictureResponseDTO;
import com.java.laurkan.interviewer.service.PictureService;
import com.java.laurkan.interviewer.utils.storage.StorageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final StorageUtil storageUtil;


    @Override
    public PictureResponseDTO save(CreatePictureRequestDTO data) throws IOException {
        String pictureName = storageUtil.store(data.getFile());
        return PictureResponseDTO
                .builder()
                .name(pictureName)
                .build();
    }

    @Override
    public void deleteByName(String name) throws IOException {
        storageUtil.remove(name);
    }
}
