package com.example.hikes.dto.response.comment;

import com.example.hikes.dto.response.reply.ReplyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String userName;
    private String description;
    private List<ReplyDTO> replies;
    private LocalDateTime CreatedAt;
}
