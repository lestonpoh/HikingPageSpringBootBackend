package com.example.hikes.mapper;


import com.example.hikes.dto.response.comment.CommentDTO;
import com.example.hikes.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommentMapper {
    @Autowired ReplyMapper replyMapper;

    public CommentDTO toCommentDTO(Comment comment){
        return new CommentDTO(
                "tempuser",
                comment.getDescription(),
                comment.getReplyIds()
                    .stream()
                    .map(replyMapper::toReplyDTO)
                    .collect(Collectors.toList()),
                comment.getCreatedAt()
        );

    }
}
