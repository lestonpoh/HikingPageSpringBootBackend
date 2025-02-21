package com.example.hikes.mapper;

import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.dto.response.reply.ReplyDTO;
import com.example.hikes.model.Reply;
import com.example.hikes.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReplyMapper {
    public ReplyDTO toReplyDTO(Reply reply){
        return new ReplyDTO(
                reply.getUserId().getUsername(),
                reply.getDescription(),
                reply.getCreatedAt()
        );
    }

    public Reply toDocument(CreateReplyRequestDTO createReplyRequestDTO, User user){
        Reply reply = new Reply();
        reply.setUserId(user);
        reply.setDescription(createReplyRequestDTO.getDescription());
        reply.setCreatedAt(LocalDateTime.now());

        return reply;
    }
}
