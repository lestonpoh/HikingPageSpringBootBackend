package com.example.hikes.mapper;

import com.example.hikes.dto.response.reply.ReplyDTO;
import com.example.hikes.model.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public ReplyDTO toReplyDTO(Reply reply){
//        replyDTO.setUserName();

        return new ReplyDTO(
                "tempusername",
                reply.getDescription(),
                reply.getCreatedAt()
        );
    }
}
