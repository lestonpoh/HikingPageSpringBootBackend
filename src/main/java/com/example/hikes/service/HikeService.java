package com.example.hikes.service;

import com.example.hikes.dto.response.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.exception.BadRequestException;
import com.example.hikes.exception.NotFoundException;
import com.example.hikes.exception.UnauthorizedException;
import com.example.hikes.mapper.HikeMapper;
import com.example.hikes.dto.response.hike.HikeSummaryResponseDTO;
import com.example.hikes.model.Hike;
import com.example.hikes.model.User;
import com.example.hikes.repository.HikeRepository;
import com.example.hikes.repository.UserRepository;
import com.example.hikes.util.JwtTokenUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HikeService {

    @Autowired
    HikeRepository hikeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HikeMapper hikeMapper;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public List<HikeSummaryResponseDTO> getAllHikes(){
        return hikeRepository.findAllHikes().stream()
                .map(hikeMapper::toHikeSummaryDTO)
                .collect(Collectors.toList());
    }

    public HikeDetailsResponseDTO getHikeByName(String name){
        Hike hike = hikeRepository.findByName(name);
        if(hike == null){
            throw new NotFoundException("Hike not found");
        }

        return hikeMapper.toHikeDetailsDTO(hike);
    }

    public void createHike(CreateHikeRequestDTO createHikeRequestDTO,String accessToken) {
        if(accessToken == null){
            throw new UnauthorizedException("Unauthorized");
        }

        ObjectId userId;
        try{
            userId = new ObjectId(jwtTokenUtil.getUserId(accessToken));
        }catch(Exception ex){
            throw new UnauthorizedException("Unauthorized");
        }

        if (hikeRepository.findByName(createHikeRequestDTO.getName()) != null){
            throw new BadRequestException("Hike name already exist.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UnauthorizedException("Unauthorized"));
        hikeRepository.insert(hikeMapper.toDocument(createHikeRequestDTO, user));
    }
}
