package com.example.hikes.dto.response.hike;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HikeSummaryResponseDTO {
    private String name;
    private String location;
    private int elevation;
    private int difficulty;
    private double duration;
}
