package com.example.hikes.dto.request.comment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    @NotBlank
    private String description;
    @NotNull
    private ObjectId hikeId;
}
