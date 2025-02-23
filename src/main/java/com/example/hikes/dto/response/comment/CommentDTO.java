package com.example.hikes.dto.response.comment;

import com.example.hikes.dto.response.reply.ReplyDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String username;
    private String description;
    private List<ReplyDTO> replies;
    private LocalDateTime CreatedAt;
}
