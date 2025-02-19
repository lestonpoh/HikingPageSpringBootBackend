package com.example.hikes.mapper;

import com.example.hikes.dto.request.reply.CreateReplyRequestDTO;
import com.example.hikes.dto.response.reply.ReplyDTO;
import com.example.hikes.model.Reply;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReplyMapper {
    public ReplyDTO toReplyDTO(Reply reply){
        return new ReplyDTO(
                "tempusername",
                reply.getDescription(),
                reply.getCreatedAt()
        );
    }

    public Reply toDocument(CreateReplyRequestDTO createReplyRequestDTO){
        Reply reply = new Reply();
        //      //  remember to add userId after jwt setup
        reply.setDescription(createReplyRequestDTO.getDescription());
        reply.setCreatedAt(LocalDateTime.now());

        return reply;
    }
}
