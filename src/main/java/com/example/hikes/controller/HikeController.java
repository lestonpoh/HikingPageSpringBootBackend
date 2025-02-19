package com.example.hikes.controller;

import com.example.hikes.dto.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.hike.HikeSummaryResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
        return new ResponseEntity<HikeDetailsResponseDTO>(hikeService.getHikeByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hike> createHike(@RequestBody CreateHikeRequestDTO createHikeRequestDTO) {
        return new ResponseEntity<Hike>(hikeService.createHike(createHikeRequestDTO), HttpStatus.OK);

    }
}