package com.example.hikes.service;

import com.example.hikes.dto.response.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.mapper.HikeMapper;
import com.example.hikes.dto.response.hike.HikeSummaryResponseDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.repository.HikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HikeService {

    @Autowired
    HikeRepository hikeRepository;

    @Autowired
    HikeMapper hikeMapper;

    public List<HikeSummaryResponseDTO> getAllHikes(){
        return hikeRepository.findAllHikes().stream()
                .map(hikeMapper::toHikeSummaryDTO)
                .collect(Collectors.toList());
    }

    public HikeDetailsResponseDTO getHikeByName(String name){
        return hikeMapper.toHikeDetailsDTO(hikeRepository.findHikeByName(name));
    }

    public Hike createHike(CreateHikeRequestDTO createHikeRequestDTO) {
        return hikeRepository.insert(hikeMapper.toDocument(createHikeRequestDTO));
    }

}
