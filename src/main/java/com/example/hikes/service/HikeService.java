package com.example.hikes.service;

import com.example.hikes.dto.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.mapper.HikeMapper;
import com.example.hikes.dto.hike.HikeSummaryResponseDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.repository.HikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HikeService {

    @Autowired
    private HikeRepository hikeRepository;

    @Autowired HikeMapper hikeMapper;

    public List<HikeSummaryResponseDTO> getAllHikes(){
        return hikeRepository.findAllHikes().stream()
                .map(hikeMapper::toHikeSummaryDTO)
                .collect(Collectors.toList());
    }

    public HikeDetailsResponseDTO hikeByName(String name){
        return hikeMapper.toHikeDetailsDTO(hikeRepository.findHikeByName(name));
    }

    public Hike createHike(CreateHikeRequestDTO createHikeRequestDTO) {
        Hike hike = new Hike();

        //  remember to add userId after jwt setup
        hike.setName(createHikeRequestDTO.getName());
        hike.setDescription(createHikeRequestDTO.getDescription());
        hike.setLocation(createHikeRequestDTO.getLocation());
        hike.setElevation(createHikeRequestDTO.getElevation());
        hike.setDifficulty(createHikeRequestDTO.getDifficulty());
        hike.setDuration(createHikeRequestDTO.getDuration());
        hike.setCreatedAt(LocalDateTime.now());

        hikeRepository.insert(hike);

        return hike;
    }

}
