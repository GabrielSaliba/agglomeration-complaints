package com.example.agglomerationcomplaints.service;

import com.example.agglomerationcomplaints.domain.Image;
import com.example.agglomerationcomplaints.domain.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;

    public static byte[] toByteArray(BufferedImage bi, String format)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }

    @Transactional
    public Image upload(MultipartFile file) {
        if (!StringUtils.hasText(file.getOriginalFilename()) || !StringUtils.hasText(file.getContentType())) {
            exception("File is empty or invalid.");
        }
        try {
            Image image = new Image();
            image.setFile(file.getBytes());
            return repository.save(image);
        } catch (Exception exception) {
            exception("Cannot save image. Try again.");
        }
        throw exception("Cannot save image. Try again.");
    }

    @Transactional(readOnly = true)
    public Image getImage(Long id) {
        return repository.findById(id).orElseThrow(() -> exception("Image not found"));
    }

    private ResponseStatusException exception(String message) {
        return exception(HttpStatus.BAD_REQUEST, message);
    }

    private ResponseStatusException exception(HttpStatus status, String message) {
        throw new ResponseStatusException(status, message);
    }
}
