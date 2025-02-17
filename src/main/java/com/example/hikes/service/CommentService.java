package com.example.hikes.service;

import com.example.hikes.dto.request.comment.CreateCommentRequestDTO;
import com.example.hikes.model.Comment;
import com.example.hikes.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CommentService {
    @Autowired CommentRepository commentRepository;

    public Comment createComment(CreateCommentRequestDTO createCommentRequestDTO){
        Comment comment = new Comment();
//      //  remember to add userId after jwt setup
        comment.setDescription(createCommentRequestDTO.getDescription());
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.insert(comment);

        return comment;
    }
}
