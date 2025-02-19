package com.example.hikes.controller;

import com.example.hikes.dto.response.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.response.hike.HikeSummaryResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/hike")
public class HikeController {
    @Autowired
    HikeService hikeService;

    @GetMapping
    public ResponseEntity<List<HikeSummaryResponseDTO>> getAllHikes() {
        return new ResponseEntity<>(hikeService.getAllHikes(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<HikeDetailsResponseDTO> getHikeByName(@PathVariable String name) {
        return new ResponseEntity<>(hikeService.getHikeByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hike> createHike(@RequestBody CreateHikeRequestDTO createHikeRequestDTO) {
        return new ResponseEntity<>(hikeService.createHike(createHikeRequestDTO), HttpStatus.OK);

    }
}