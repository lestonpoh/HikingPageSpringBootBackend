package com.example.hikes.controller;

import com.example.hikes.dto.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.hike.HikeSummaryResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/hike")
public class HikeController {
    @Autowired
    private HikeService hikeService;

    @GetMapping
    public ResponseEntity<List<HikeSummaryResponseDTO>> getAllHikes() {
        return new ResponseEntity<List<HikeSummaryResponseDTO>>(hikeService.getAllHikes(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<HikeDetailsResponseDTO> getHikeByName(@PathVariable String name) {
        return new ResponseEntity<HikeDetailsResponseDTO>(hikeService.hikeByName(name), HttpStatus.OK);
    }

    public Hike createHike(CreateHikeRequestDTO createHikeRequestDTO) {
        Hike hike = new Hike();

        hike.setName(createHikeRequestDTO.getName());
        hike.setDescription(createHikeRequestDTO.getDescription());
        hike.setLocation(createHikeRequestDTO.getLocation());
        hike.setElevation(createHikeRequestDTO.getElevation());
        hike.setDifficulty(createHikeRequestDTO.getDifficulty());
        hike.setDuration(createHikeRequestDTO.getDuration());
        hike.setCreatedAt(LocalDateTime.now());

        return hike;
    }
}