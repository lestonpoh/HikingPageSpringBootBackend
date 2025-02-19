package com.example.hikes.dto.request.hike;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHikeRequestDTO {
    private String name;
    private String description;
    private String location;
    private int elevation;
    private int difficulty;
    private double duration;
}
