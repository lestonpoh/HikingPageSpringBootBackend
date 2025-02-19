package com.example.hikes.dto.request.comment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    private String description;
    private String hikeName;
}
