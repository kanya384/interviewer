package com.java.laurkan.interviewer.utils.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageUtil {
    String store(MultipartFile file) throws IOException;

    void remove(String fileName) throws IOException;
}
