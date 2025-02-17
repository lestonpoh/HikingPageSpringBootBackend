package com.example.hikes.mapper;

import com.example.hikes.dto.hike.HikeDetailsResponseDTO;
import com.example.hikes.dto.hike.HikeSummaryResponseDTO;
import com.example.hikes.model.Hike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class HikeMapper {
    @Autowired CommentMapper commentMapper;

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
}
