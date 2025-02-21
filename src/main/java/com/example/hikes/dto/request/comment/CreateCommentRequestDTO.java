package com.example.hikes.dto.request.comment;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    @NotBlank
    private String description;
    @NotBlank
    private String hikeName;
}
