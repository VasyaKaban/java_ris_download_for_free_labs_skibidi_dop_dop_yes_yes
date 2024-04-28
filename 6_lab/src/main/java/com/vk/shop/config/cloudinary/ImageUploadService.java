package com.vk.shop.config.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {

    Map uploadImage(MultipartFile multipartFile);

    Map deleteImage(String imageId);
}
