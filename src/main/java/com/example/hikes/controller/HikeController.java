package com.example.hikes.controller;

import com.example.hikes.dto.Hike;
import com.example.hikes.service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hike")
public class HikeController {
    @Autowired
    private HikeService hikeService;

    @GetMapping
    public ResponseEntity<List<Hike>> getAllHikes(){
        return new ResponseEntity<List<Hike>>( hikeService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Hike>> getHikeByName(@PathVariable String name){
        return new ResponseEntity<Optional<Hike>>(hikeService.hikeByName(name), HttpStatus.OK);
    }

}
