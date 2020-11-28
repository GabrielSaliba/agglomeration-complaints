package com.example.agglomerationcomplaints.controller;

import com.example.agglomerationcomplaints.domain.Agglomeration;
import com.example.agglomerationcomplaints.service.AgglomerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/agglomeration")
@RestController
public class AgglomerationController {

    private final AgglomerationService agglomerationService;

    @PostMapping("/create")
    public ResponseEntity<Agglomeration> createAgglomeration(@RequestBody Agglomeration agglomeration) throws IOException {
        log.info("REST Request to create new agglomeration");
        return agglomerationService.createAgglomeration(agglomeration);
    }

    @PutMapping("/update")
    public Agglomeration updateAgglomeration(@RequestBody Agglomeration agglomeration) {
        log.info("REST Request to update agglomeration");
        return agglomerationService.updateAgglomeration(agglomeration);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgglomeration(@PathVariable Long id) {
        log.info("REST Request to delete agglomeration: {}", id);
        agglomerationService.deleteAgglomeration(id);
    }

    @GetMapping("/{id}")
    public Agglomeration getAgglomeration(@PathVariable Long id) {
        log.info("REST Request to get agglomeration by id: {}", id);
        return agglomerationService.getAgglomeration(id);
    }

    @GetMapping
    public List<Agglomeration> getUserAgglomerations() {
        log.info("REST Request to get all user agglomerations");
        return agglomerationService.getUserAgglomerations();
    }
}
