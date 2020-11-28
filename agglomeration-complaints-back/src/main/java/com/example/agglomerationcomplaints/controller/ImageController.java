package com.example.agglomerationcomplaints.controller;

import com.example.agglomerationcomplaints.domain.Image;
import com.example.agglomerationcomplaints.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public Image saveImage(@RequestBody MultipartFile file) {
        log.info("REST Request to upload image: {}", file.getOriginalFilename());
        return imageService.upload(file);
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable Long id) {
        log.info("REST Request to get image by Id: {}", id);
        return imageService.getImage(id);
    }
}
