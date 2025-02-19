package com.example.hikes.dto.request.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReplyRequestDTO {
    private ObjectId commentId;
    private String description;
}
