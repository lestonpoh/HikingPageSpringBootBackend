package com.example.hikes.dto.request.comment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    private String description;
    private LocalDateTime createdAt;
    private String hikeName;
}
