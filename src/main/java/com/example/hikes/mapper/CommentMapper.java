package com.example.hikes.mapper;


import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.dto.response.comment.CommentDTO;
import com.example.hikes.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class CommentMapper {
    @Autowired
    private ReplyMapper replyMapper;

    public CommentDTO toCommentDTO(Comment comment){
        return new CommentDTO(
                comment.getId(),
                "tempuser",
                comment.getDescription(),
                comment.getReplyIds()
                    .stream()
                    .map(replyMapper::toReplyDTO)
                    .collect(Collectors.toList()),
                comment.getCreatedAt()
        );
    }

    public Comment toDocument(CreateCommentRequestDTO createCommentRequestDTO){
        Comment comment = new Comment();
//      //  remember to add userId after jwt setup
        comment.setDescription(createCommentRequestDTO.getDescription());
        comment.setCreatedAt(LocalDateTime.now());

        return comment;
    }
}
