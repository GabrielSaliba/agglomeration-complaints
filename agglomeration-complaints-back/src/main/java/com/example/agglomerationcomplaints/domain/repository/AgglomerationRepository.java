package com.example.agglomerationcomplaints.domain.repository;

import com.example.agglomerationcomplaints.domain.Agglomeration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgglomerationRepository extends JpaRepository<Agglomeration, Long> {
}
