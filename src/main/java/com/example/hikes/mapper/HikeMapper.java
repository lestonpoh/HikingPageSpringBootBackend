package com.example.hikes.mapper;

import com.example.hikes.dto.response.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.response.hike.HikeSummaryResponseDTO;
import com.example.hikes.dto.request.hike.CreateHikeRequestDTO;
import com.example.hikes.model.Hike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class HikeMapper {
    @Autowired
    private CommentMapper commentMapper;

    public HikeSummaryResponseDTO toHikeSummaryDTO(Hike hike){
        return new HikeSummaryResponseDTO(
                hike.getName(),
                hike.getLocation(),
                hike.getElevation(),
                hike.getDifficulty(),
                hike.getDuration()
        );
    }

    public HikeDetailsResponseDTO toHikeDetailsDTO(Hike hike){;
        return new HikeDetailsResponseDTO(
                hike.getName(),
                hike.getDescription(),
                hike.getLocation(),
                hike.getElevation(),
                hike.getDifficulty(),
                hike.getDuration(),
                hike.getCommentIds()
                    .stream()
                    .map(commentMapper::toCommentDTO)
                    .collect(Collectors.toList())
        );
    }

    public Hike toDocument(CreateHikeRequestDTO createHikeRequestDTO){
        Hike hike = new Hike();
        //  remember to add userId after jwt setup
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
