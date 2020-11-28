package com.example.agglomerationcomplaints.domain.repository;

import com.example.agglomerationcomplaints.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
