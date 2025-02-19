package com.example.hikes.dto.request.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReplyRequestDTO {
    @NotBlank
    private String commentId;
    @NotBlank
    private String description;
}
