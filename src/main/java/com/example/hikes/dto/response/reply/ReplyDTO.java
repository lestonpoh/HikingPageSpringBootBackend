package com.example.hikes.dto.response.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private String username;
    private String description;
    private LocalDateTime CreatedAt;
}
