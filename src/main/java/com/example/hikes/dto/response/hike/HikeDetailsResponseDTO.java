package com.example.hikes.dto.hike;

import com.example.hikes.dto.response.comment.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HikeDetailsResponseDTO {
    private String name;
    private String description;
    private String location;
    private int elevation;
    private int difficulty;
    private double duration;
    private List<CommentDTO> comments;
}
