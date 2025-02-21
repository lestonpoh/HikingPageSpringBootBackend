package com.example.hikes.mapper;


import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.dto.response.comment.CommentDTO;
import com.example.hikes.model.Comment;
import com.example.hikes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class CommentMapper {
    @Autowired
    ReplyMapper replyMapper;

    public CommentDTO toCommentDTO(Comment comment){
        return new CommentDTO(
                comment.getId(),
                comment.getUserId().getUsername(),
                comment.getDescription(),
                comment.getReplyIds()
                    .stream()
                    .map(replyMapper::toReplyDTO)
                    .collect(Collectors.toList()),
                comment.getCreatedAt()
        );
    }

    public Comment toDocument(CreateCommentRequestDTO createCommentRequestDTO, User user){
        Comment comment = new Comment();
        comment.setUserId(user);
        comment.setDescription(createCommentRequestDTO.getDescription());
        comment.setCreatedAt(LocalDateTime.now());

        return comment;
    }
}
