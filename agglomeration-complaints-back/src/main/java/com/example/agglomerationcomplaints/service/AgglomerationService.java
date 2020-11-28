package com.example.agglomerationcomplaints.service;

import com.example.agglomerationcomplaints.domain.Agglomeration;
import com.example.agglomerationcomplaints.domain.Image;
import com.example.agglomerationcomplaints.domain.repository.AgglomerationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AgglomerationService {

    private final AgglomerationRepository agglomerationRepository;
    private final ImageService imageService;

    @Transactional
    public ResponseEntity<Agglomeration> createAgglomeration(Agglomeration agglomeration) {
        if(agglomeration.getImage().getId() != null) {
            Agglomeration agglomerationSaved = agglomerationRepository.save(agglomeration);
            return new ResponseEntity<>(agglomerationSaved, HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agglomeration with no image.");
    }

    @Transactional
    public Agglomeration updateAgglomeration(Agglomeration agglomeration) {
        if (agglomeration.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agglomeration not found.");
        }

        Image imageAgglomeration = getAgglomeration(agglomeration.getId()).getImage();
        agglomeration.setImage(imageAgglomeration);
        return agglomerationRepository.save(agglomeration);
    }

    @Transactional
    public void deleteAgglomeration(Long id) {
        agglomerationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agglomeration not found."));
        agglomerationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Agglomeration getAgglomeration(Long id) {
        return agglomerationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agglomeration not found."));
    }

    @Transactional(readOnly = true)
    public List<Agglomeration> getUserAgglomerations() {
        return agglomerationRepository.findAll();
    }
}
