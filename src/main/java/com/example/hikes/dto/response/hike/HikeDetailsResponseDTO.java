package com.example.hikes.dto.response.hike;

import com.example.hikes.dto.response.comment.CommentDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HikeDetailsResponseDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private String description;
    private String location;
    private int elevation;
    private int difficulty;
    private double duration;
    private List<CommentDTO> comments;
}
