package com.example.hikes.service;

import com.example.hikes.dto.Hike;
import com.example.hikes.repository.HikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HikeService {

    @Autowired
    private HikeRepository hikeRepository;

    public List<Hike> allMovies(){
        return hikeRepository.findAll();
    }

    public Optional<Hike> hikeByName(String name){
        return hikeRepository.findHikeByName(name);
    }
}
